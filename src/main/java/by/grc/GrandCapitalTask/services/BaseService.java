package by.grc.GrandCapitalTask.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public abstract class BaseService<E, R extends JpaRepository<E, Long>> {

    protected final R repo;

    protected void save(E entity) {
        repo.save(entity);
    }

    protected List<E> getAll() {
        return this.repo.findAll();
    }

    protected Optional<E> getById(Long id) {
        if (id == null)
            return Optional.empty();
        return this.repo.findById(id);
    }

    protected void deleteById(Long id) {
        this.repo.deleteById(id);
    }
}
