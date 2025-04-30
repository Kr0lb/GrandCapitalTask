package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.User;
import by.grc.GrandCapitalTask.repositories.UserRepository;
import by.grc.GrandCapitalTask.repositories.UserSpecification;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService extends BaseService<User, UserRepository> {

    public UserService(UserRepository repo) {
        super(repo);
    }

    public List<User> searchUser(String dateOfBirth, String phone, String name, String email, int page, int size) {
        LocalDate date = dateOfBirth == null ? null : LocalDate.parse(dateOfBirth);
        Specification<User> spec = Specification.where(UserSpecification.dateOfBirthGreaterThan(date))
                .and(UserSpecification.likeName(name))
                .and(UserSpecification.hasPhone(phone))
                .and(UserSpecification.hasEmail(email));

        return this.repo.findAll(spec, PageRequest.of(page, size)).getContent();
    }

    public Optional<User> getByEmails(String email) {
        return this.repo.findByEmails_Email(email);
    }

}
