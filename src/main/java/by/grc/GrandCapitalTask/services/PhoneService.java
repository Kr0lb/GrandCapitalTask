package by.grc.GrandCapitalTask.services;

import by.grc.GrandCapitalTask.models.Phone;
import by.grc.GrandCapitalTask.repositories.PhoneRepository;
import org.springframework.stereotype.Service;

@Service
public class PhoneService extends BaseService<Phone, PhoneRepository> {

    public PhoneService(PhoneRepository repo) {
        super(repo);
    }

    public void delete(Phone phone) {
        this.repo.deleteById(phone.getId());
    }

    public Phone save(Phone phone) {
        return this.repo.save(phone);
    }

    public Phone update(Phone phone) {
        return this.repo.save(phone);
    }
}
