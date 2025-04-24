package by.grc.GrandCapitalTask.repositories;

import by.grc.GrandCapitalTask.models.User;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class UserSpecification {
    public static Specification<User> dateOfBirthGreaterThan(LocalDate dateOfBirth) {
        return (root, query, cb) -> dateOfBirth == null ? null : cb.greaterThan(root.get("dateOfBirth"), dateOfBirth);
    }

    public static Specification<User> hasPhone(String phone) {
        return (root, query, cb) -> phone == null ? null : cb.equal(root.get("phones").get("phone"), phone);
    }

    public static Specification<User> likeName(String name) {
        return (root, query, cb) -> name == null ? null : cb.like(root.get("name"), name.concat("%"));
    }

    public static Specification<User> hasEmail(String email) {
        return (root, query, cb) -> email == null ? null : cb.equal(root.get("emails").get("email"), email);
    }
}
