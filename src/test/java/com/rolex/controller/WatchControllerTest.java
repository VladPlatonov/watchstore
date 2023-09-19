package com.rolex.controller;

import com.rolex.model.watches.MechanicalWatch;
import com.rolex.model.watches.Watch;
import com.rolex.service.WatchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WatchControllerTest {

    @Mock
    private WatchService service;

    @InjectMocks
    private WatchController controller;

    @Test
    void shouldAddWatch_whenWatchIsProvided() {
        Watch watch = MechanicalWatch.builder().build();

        controller.addWatch(watch);

        verify(service, times(1)).addWatch(watch);
    }

    @Test
    void shouldReturnAllWatches_whenGetAllWatchesIsCalled() {
        List<Watch> watches = new ArrayList<>();
        when(service.getAllWatches()).thenReturn(watches);

        List<Watch> result = controller.getAllWatches();

        assertEquals(watches, result);
        verify(service, times(1)).getAllWatches();
    }

    @Test
    void shouldReturnTotalPrice_whenGetTotalPriceIsCalled() {
        when(service.getTotalPrice()).thenReturn(3000L);

        Long totalPrice = controller.getTotalPrice();

        assertEquals(3000L, totalPrice);
        verify(service, times(1)).getTotalPrice();
    }

    @Test
    void shouldReturnWatchesSortedByPrice_whenSortByPriceIsCalled() {
        List<Watch> watches = new ArrayList<>();
        when(service.sortByPrice()).thenReturn(watches);

        List<Watch> sortedWatches = controller.sortByPrice();

        assertEquals(watches, sortedWatches);
        verify(service, times(1)).sortByPrice();
    }

    @Test
    void shouldReturnWatchesSortedByColor_whenSortByColorIsCalled() {
        List<Watch> watches = new ArrayList<>();
        when(service.sortByColor()).thenReturn(watches);

        List<Watch> sortedWatches = controller.sortByColor();

        assertEquals(watches, sortedWatches);
        verify(service, times(1)).sortByColor();
    }

    @Test
    void shouldReturnWatchesSortedByArrivalDate_whenSortByArrivalDateIsCalled() {
        List<Watch> watches = new ArrayList<>();
        when(service.sortByArrivalDate()).thenReturn(watches);

        List<Watch> sortedWatches = controller.sortByArrivalDate();

        assertEquals(watches, sortedWatches);
        verify(service, times(1)).sortByArrivalDate();
    }
}
