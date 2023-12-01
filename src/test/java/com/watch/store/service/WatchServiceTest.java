package com.watch.store.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.watch.store.model.MechanicalWatch;
import com.watch.store.model.SolarWatch;
import com.watch.store.model.Watch;
import com.watch.store.repository.WatchRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WatchServiceTest {

    @Mock
    private WatchRepository repository;

    @InjectMocks
    private WatchService service;

    @Test
    void shouldAddWatch_whenWatchIsProvided() {
        Watch watch = MechanicalWatch.builder().build();
        when(repository.save(watch)).thenReturn(watch);

        service.addWatch(watch);

        verify(repository, times(1)).save(watch);
    }

    @Test
    void shouldReturnAllWatches_whenGetAllWatchesIsCalled() {
        List<Watch> watches = new ArrayList<>();
        when(repository.findAll()).thenReturn(watches);

        List<Watch> result = service.getAllWatches();

        assertEquals(watches, result);
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnTotalPrice_whenGetTotalPriceIsCalled() {
        Watch watch1 = MechanicalWatch.builder().price(BigDecimal.valueOf(1000L)).build();
        Watch watch2 = SolarWatch.builder().price(BigDecimal.valueOf(2000L)).build();

        List<Watch> watches = new ArrayList<>();
        watches.add(watch1);
        watches.add(watch2);

        when(repository.findAll()).thenReturn(watches);

        BigDecimal totalPrice = service.getTotalPrice();

        assertEquals(BigDecimal.valueOf(3000L), totalPrice);
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnWatchesSortedByPrice_whenSortByPriceIsCalled() {
        List<Watch> watches = new ArrayList<>();
        when(repository.findAll()).thenReturn(watches);

        List<Watch> sortedWatches = service.sortByPrice();

        assertEquals(watches, sortedWatches);
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnWatchesSortedByColor_whenSortByColorIsCalled() {
        List<Watch> watches = new ArrayList<>();
        when(repository.findAll()).thenReturn(watches);

        List<Watch> sortedWatches = service.sortByColor();

        assertEquals(watches, sortedWatches);
        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnWatchesSortedByArrivalDate_whenSortByArrivalDateIsCalled() {
        List<Watch> watches = new ArrayList<>();
        when(repository.findAll()).thenReturn(watches);

        List<Watch> sortedWatches = service.sortByArrivalDate();

        assertEquals(watches, sortedWatches);
        verify(repository, times(1)).findAll();
    }

}
