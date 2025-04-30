package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.Email;
import by.grc.GrandCapitalTask.repositories.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService extends BaseService<Email, EmailRepository> {

    public EmailService(EmailRepository repo) {
        super(repo);
    }

    public void delete(Email email) {
        this.repo.deleteById(email.getId());
    }

    public Email save(Email email) {
        return this.repo.save(email);
    }

    public Email update(Email email) {
        return this.repo.save(email);
    }
}
