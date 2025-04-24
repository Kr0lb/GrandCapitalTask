package by.grc.GrandCapitalTask.repositories;

import by.grc.GrandCapitalTask.models.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
    boolean existsByStatusIsTrueAndAccount_Id(Long id);

    Deposit findByStatusIsTrueAndAccount_Id(Long id);
}
