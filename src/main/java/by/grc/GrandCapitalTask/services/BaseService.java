package by.grc.GrandCapitalTask.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseService<E, R extends JpaRepository<E, Long>> {

    protected final R repo;

    public void save(E entity) {
        repo.save(entity);
    }

    public List<E> getAll() {
        return this.repo.findAll();
    }

    public Optional<E> getById(Long id) {
        if (id == null)
            return Optional.empty();
        return this.repo.findById(id);
    }

    public void deleteById(Long id) {
        this.repo.deleteById(id);
    }
}
