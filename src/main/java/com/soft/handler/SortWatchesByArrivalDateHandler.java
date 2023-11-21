package com.soft.handler;

import com.soft.service.WatchService;

/**
 * A menu handler that sorts watches by arrival date.
 */
public class SortWatchesByArrivalDateHandler implements MenuHandler {

    private final WatchService service;

    public SortWatchesByArrivalDateHandler(WatchService service) {
        this.service = service;
    }

    @Override
    public void handle() {
        service.sortByArrivalDate().forEach(System.out::println);
    }

    @Override
    public String getMenuDescription() {
        return "3. Sort watches by arrival date";
    }
}
