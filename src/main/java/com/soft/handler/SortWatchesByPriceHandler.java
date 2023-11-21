package com.soft.handler;

import com.soft.service.WatchService;

/**
 * A menu handler that sorts watches by price.
 */
public class SortWatchesByPriceHandler implements MenuHandler {

    private final WatchService service;

    public SortWatchesByPriceHandler(WatchService service) {
        this.service = service;
    }

    @Override
    public void handle() {
        service.sortByPrice().forEach(System.out::println);
    }

    @Override
    public String getMenuDescription() {
        return "5. Sort watches by price";
    }

}
