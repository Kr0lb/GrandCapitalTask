package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.Account;
import by.grc.GrandCapitalTask.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService<Account, AccountRepository> {

    public AccountService(AccountRepository repo) {
        super(repo);
    }
}
