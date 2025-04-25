package by.grc.GrandCapitalTask.repositories;

import by.grc.GrandCapitalTask.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query("select e.user from Email e where position (e.email in :email) > 0")
    Optional<User> findByEmails_Email(String email);
}
