package com.rolex.handler;

import com.rolex.controller.WatchController;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
@RequiredArgsConstructor
public class SortWatchesByColorHandler implements MenuHandler {

    private final WatchController controller;

    @Override
    public void handle() {
        controller.sortByColor().forEach(System.out::println);
    }

    @Override
    public String getMenuDescription() {
        return "4. Sort watches by color";
    }

}
