package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.Email;
import by.grc.GrandCapitalTask.repositories.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService extends BaseService<Email, EmailRepository> {

    public EmailService(EmailRepository repo) {
        super(repo);
    }

    public void delete(Long Id) {
        this.repo.deleteById(Id);
    }

    public void save(Email email) {
        this.repo.save(email);
    }

    public Email update(Email email) {
        return this.repo.save(email);
    }
}
