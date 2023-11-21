package com.soft.handler;

/**
 * A menu handler that exits the application.
 */
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
