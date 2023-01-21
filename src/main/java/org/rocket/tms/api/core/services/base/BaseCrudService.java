package org.rocket.tms.api.core.services.base;

import org.rocket.tms.api.core.entities.base.EntityWithId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public class BaseCrudService<T extends EntityWithId, R extends CrudRepository<T, Long>> {
    protected final R repository;

    public BaseCrudService(R repository) {
        this.repository = repository;
    }

    public boolean delete(long id) {
        if (!repository.existsById(id))
            return false;
        repository.deleteById(id);
        return true;
    }

    public Optional<T> select(long id) {
        return repository.findById(id);
    }

    public Optional<T> create(T entity) {
        return Optional.of(repository.save(entity));
    }

    public Optional<T> update(long id, T updatedCase) {
        return  !repository.existsById(id)
                ? Optional.empty()
                : Optional.of(repository.save(updatedCase));
    }
}
