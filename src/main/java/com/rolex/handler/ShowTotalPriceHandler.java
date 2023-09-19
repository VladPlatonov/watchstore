package com.rolex.handler;

import com.rolex.controller.WatchController;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@RequiredArgsConstructor
public class ShowTotalPriceHandler implements MenuHandler {

    private final WatchController controller;

    @Override
    public void handle() {
        System.out.println("Total price: " + controller.getTotalPrice());
    }

    @Override
    public String getMenuDescription() {
        return "2. Show total price of all watches";
    }
}
