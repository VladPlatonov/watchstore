package com.soft.handler;

import com.soft.service.WatchService;

/**
 * A menu handler that shows all watches.
 */
public class SortWatchesByColorHandler implements MenuHandler {

    private final WatchService service;

    public SortWatchesByColorHandler(WatchService service) {
        this.service = service;
    }

    @Override
    public void handle() {
        service.sortByColor().forEach(System.out::println);
    }

    @Override
    public String getMenuDescription() {
        return "4. Sort watches by color";
    }

}
