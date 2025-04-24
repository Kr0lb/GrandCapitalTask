package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.Account;
import by.grc.GrandCapitalTask.models.Deposit;
import by.grc.GrandCapitalTask.repositories.AccountRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
public class AccountService extends BaseService<Account, AccountRepository> {

    private final DepositService depositService;

    public AccountService(AccountRepository repo, DepositService depositService) {
        super(repo);
        this.depositService = depositService;
    }

    @Scheduled(cron = "0/30 * * * * *")
    private void interestAccrual() {
        System.out.println(LocalDateTime.now() + " wait");
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
}
