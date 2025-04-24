package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.User;
import by.grc.GrandCapitalTask.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, UserRepository> {
    public UserService(UserRepository repo) {
        super(repo);
    }
}
