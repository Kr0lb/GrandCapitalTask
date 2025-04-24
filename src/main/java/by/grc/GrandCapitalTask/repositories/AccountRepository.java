package by.grc.GrandCapitalTask.repositories;

import by.grc.GrandCapitalTask.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
