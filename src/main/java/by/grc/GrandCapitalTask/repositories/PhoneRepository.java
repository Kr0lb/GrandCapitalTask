package by.grc.GrandCapitalTask.repositories;

import by.grc.GrandCapitalTask.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
