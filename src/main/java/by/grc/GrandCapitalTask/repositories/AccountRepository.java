package by.grc.GrandCapitalTask.repositories;

import by.grc.GrandCapitalTask.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUser_Id(Long userId);

    @Query("select (acc.balance) < 0  from Account acc where acc.user.id = :userId")
    boolean existNegativeBalance(Long userId);
}
