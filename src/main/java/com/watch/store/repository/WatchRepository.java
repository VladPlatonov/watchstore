package com.watch.store.repository;

import com.watch.store.model.Watch;

public class WatchRepository extends HashMapRepository<Watch> {

    @Override
    protected Long getEntityId(Watch entity) {
        return entity.getId();
    }

    @Override
    protected void setEntityId(Watch entity, Long id) {
        entity.setId(id);
    }
}
