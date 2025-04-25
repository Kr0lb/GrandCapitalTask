package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.dtos.EmailDto;
import by.grc.GrandCapitalTask.mapper.Mapper;
import by.grc.GrandCapitalTask.models.Email;
import by.grc.GrandCapitalTask.repositories.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService extends BaseService<Email, EmailRepository> {

    private final Mapper<Email, EmailDto> mapper;

    public EmailService(EmailRepository repo, Mapper<Email, EmailDto> mapper) {
        super(repo);
        this.mapper = mapper;
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
