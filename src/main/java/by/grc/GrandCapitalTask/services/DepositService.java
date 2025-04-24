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

    public void startDeposit(Account account) {
        if (!repo.existsByStatusIsTrueAndAccount_Id(account.getId())) {
            Deposit deposit = new Deposit(null, true, account, account.getBalance(), 0.1, 2.07);
            this.repo.save(deposit);
        }
    }
}
