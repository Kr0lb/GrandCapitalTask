package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.Account;
import by.grc.GrandCapitalTask.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService<Account,AccountRepository> {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository repo, AccountRepository accountRepository) {
        super(repo);
        this.accountRepository = accountRepository;
    }

    @Scheduled(cron = "30 * * * * *")
    private void interestAccrual() {

    }
}
