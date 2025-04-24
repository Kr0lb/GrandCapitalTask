package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.Account;
import by.grc.GrandCapitalTask.models.Deposit;
import by.grc.GrandCapitalTask.repositories.AccountRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService<Account, AccountRepository> {

    private final DepositService depositService;

    public AccountService(AccountRepository repo, DepositService depositService) {
        super(repo);
        this.depositService = depositService;
    }

    @Scheduled(cron = "30 * * * * *")
    private void interestAccrual() {
        this.repo.findAll().forEach(account -> {
            Deposit deposit = this.depositService.repo.findByStatusIsTrueAndAccount_Id(account.getId());
            if (deposit != null && !(deposit.getAmountStopped() * account.getBalance() > deposit.getAmount() * account.getBalance()))
                account.setBalance(deposit.getStartBalance() * deposit.getAmount() + account.getBalance());
        });
    }
}
