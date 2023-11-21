package com.soft.handler;

import com.soft.service.WatchService;

/**
 * A menu handler that shows the total price of all watches.
 */
public class ShowTotalPriceHandler implements MenuHandler {

    private final WatchService service;

    public ShowTotalPriceHandler(WatchService service) {
        this.service = service;
    }

    @Override
    public void handle() {
        System.out.println("Total price: " + service.getTotalPrice());
    }

    @Override
    public String getMenuDescription() {
        return "2. Show total price of all watches";
    }
}
