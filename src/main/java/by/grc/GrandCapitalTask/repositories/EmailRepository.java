package by.grc.GrandCapitalTask.repositories;

import by.grc.GrandCapitalTask.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
}
