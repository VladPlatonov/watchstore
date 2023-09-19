package com.rolex.handler;

import com.rolex.controller.WatchController;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@RequiredArgsConstructor
public class SortWatchesByArrivalDateHandler implements MenuHandler {

    private final WatchController controller;

    @Override
    public void handle() {
        controller.sortByArrivalDate().forEach(System.out::println);
    }

    @Override
    public String getMenuDescription() {
        return "3. Sort watches by arrival date";
    }
}
