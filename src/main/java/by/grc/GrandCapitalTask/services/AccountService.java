package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.Account;
import by.grc.GrandCapitalTask.models.Deposit;
import by.grc.GrandCapitalTask.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class AccountService extends BaseService<Account, AccountRepository> {

    private final DepositService depositService;

    public AccountService(AccountRepository repo, DepositService depositService) {
        super(repo);
        this.depositService = depositService;
    }

    //    @Scheduled(cron = "0/30 * * * * *")
    public void interestAccrual() {
        this.repo.findAll().forEach(account -> {
            Deposit deposit = this.depositService.repo.findByStatusIsTrueAndAccount_Id(account.getId());
            if (deposit != null && (deposit.getAmountStopped() * deposit.getStartBalance() > deposit.getStartBalance() * deposit.getAmount() + account.getBalance())) {
                account.setBalance(this.round(deposit.getStartBalance() * deposit.getAmount() + account.getBalance()));
                this.repo.save(account);
            }
        });
    }

    private Double round(Double value) {
        return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Transactional
    public synchronized void transfer(Long userId, Long clientId, Double price) {
            Account account = this.repo.findByUser_Id(userId);
            account.setBalance(this.round(account.getBalance() - price));
            this.repo.save(account);
            Account client = this.repo.findByUser_Id(clientId);
            client.setBalance(this.round(client.getBalance() + price));
            this.repo.save(client);
            if (this.repo.existNegativeBalance(userId)) throw new RuntimeException("Balance not enough");
    }
}
