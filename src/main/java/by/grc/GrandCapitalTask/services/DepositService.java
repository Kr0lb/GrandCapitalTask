package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.Account;
import by.grc.GrandCapitalTask.models.Deposit;
import by.grc.GrandCapitalTask.repositories.DepositRepository;
import org.springframework.stereotype.Service;

@Service
public class DepositService extends BaseService<Deposit, DepositRepository> {
    public DepositService(DepositRepository repo) {
        super(repo);
    }
}
