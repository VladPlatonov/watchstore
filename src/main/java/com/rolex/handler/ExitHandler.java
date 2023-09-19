package com.rolex.handler;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
public class ExitHandler implements MenuHandler {

    @Override
    public void handle() {
        System.exit(0);
    }

    @Override
    public String getMenuDescription() {
        return "0. Exit";
    }

}
