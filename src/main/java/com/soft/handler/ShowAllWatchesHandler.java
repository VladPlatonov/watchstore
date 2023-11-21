package com.soft.handler;

import com.soft.service.WatchService;

/**
 * A menu handler that shows all watches.
 */
public class ShowAllWatchesHandler implements MenuHandler {

    private final WatchService service;

    public ShowAllWatchesHandler(WatchService service) {
        this.service = service;
    }

    @Override
    public void handle() {
        service.getAllWatches().forEach(System.out::println);
    }

    @Override
    public String getMenuDescription() {
        return "1. Show all watches";
    }
}
