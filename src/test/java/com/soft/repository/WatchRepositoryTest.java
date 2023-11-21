package com.soft.repository;
import com.soft.model.MechanicalWatch;
import com.soft.model.QuartzWatch;
import com.soft.model.SolarWatch;
import com.soft.model.Watch;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class WatchRepositoryTest {

    private WatchRepository repository;

    @BeforeEach
    void setUp() {
        repository = new WatchRepository();
    }

    @Test
    void shouldReturnEntityId_whenGetEntityIdIsCalled() {
        Watch watch = MechanicalWatch.builder().build();
        Long expectedId = 1L;
        watch.setId(expectedId);

        Long entityId = repository.getEntityId(watch);

        assertEquals(expectedId, entityId);
    }

    @Test
    void shouldSetEntityId_whenSetEntityIdIsCalled() {
        Watch watch = SolarWatch.builder().build();
        Long expectedId = 1L;

        repository.setEntityId(watch, expectedId);

        assertEquals(expectedId, watch.getId());
    }

    @Test
    void shouldSaveAndRetrieveEntity_whenUsingRepositoryMethods() {
        Watch watch = QuartzWatch.builder().build();
        watch.setId(1L);

        repository.save(watch);
        Optional<Watch> retrievedWatch = repository.findById(1L);

        assertTrue(retrievedWatch.isPresent());
        assertEquals(watch, retrievedWatch.get());
    }

    @Test
    void shouldReturnAllWatches_whenFindAllIsCalled() {
        Watch watch1 = MechanicalWatch.builder().id(1L).build();
        Watch watch2 = SolarWatch.builder().id(2L).build();

        repository.save(watch1);
        repository.save(watch2);

        List<Watch> watches = repository.findAll();

        assertNotNull(watches);
        assertEquals(2, watches.size());
        assertTrue(watches.contains(watch1));
        assertTrue(watches.contains(watch2));
    }
}
