package com.rolex.handler;

import com.rolex.controller.WatchController;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class ShowAllWatchesHandler implements MenuHandler {

    private final WatchController controller;

    @Override
    public void handle() {
        controller.getAllWatches().forEach(System.out::println);
    }

    @Override
    public String getMenuDescription() {
        return "1. Show all watches";
    }
}
