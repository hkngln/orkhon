package org.orkhon.repositories;

import org.orkhon.domain.Entity;

public interface CrudDao<T extends Entity<T>> {
    T get(Long id);

    int count();

    boolean exists(Long id);

    T save(T instance);

    void delete(Long id);
}