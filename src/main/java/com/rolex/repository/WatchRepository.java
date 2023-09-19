package com.rolex.repository;

import com.rolex.model.watches.Watch;
import org.springframework.stereotype.Repository;

@Repository
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
