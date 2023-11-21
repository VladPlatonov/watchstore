package com.soft.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class HashMapRepository<T> implements InMemoryRepository<T> {

    private final Map<Long, T> entities = new HashMap<>();

    private Long autoIncrementId = 1L;

    protected abstract Long getEntityId(T entity);

    protected abstract void setEntityId(T entity, Long id);

    @Override
    public T save(T entity) {
        Long id = getEntityId(entity);
        if (id == null || id == 0) {
            id = autoIncrementId++;
            setEntityId(entity, id);
        }

        entities.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(Long id) {
        return Optional.ofNullable(entities.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities.values());
    }

    @Override
    public void deleteById(Long id) {
        entities.remove(id);
    }
}
