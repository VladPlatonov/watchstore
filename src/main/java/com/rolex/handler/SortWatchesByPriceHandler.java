package com.rolex.handler;

import com.rolex.controller.WatchController;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(5)
@RequiredArgsConstructor
public class SortWatchesByPriceHandler implements MenuHandler {

    private final WatchController controller;

    @Override
    public void handle() {
        controller.sortByPrice().forEach(System.out::println);
    }

    @Override
    public String getMenuDescription() {
        return "5. Sort watches by price";
    }

}
