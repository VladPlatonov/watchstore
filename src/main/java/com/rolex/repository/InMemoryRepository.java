package com.rolex.repository;

import java.util.List;
import java.util.Optional;

public interface InMemoryRepository<T> {

    T save(T entity);

    Optional<T> findById(Long id);

    List<T> findAll();

    void deleteById(Long id);
}
