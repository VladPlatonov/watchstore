package com.soft.repository;

import com.soft.model.Watch;

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
