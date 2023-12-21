package com.watch.store.controller.handler;

import static com.watch.store.util.MessageConstants.MENU_OPTION_ADD_WATCH;

import com.watch.store.controller.MenuOptionController;

/**
 * A menu handler that adds a watch.
 */
public class AddWatchHandler implements MenuHandler {

    private final MenuOptionController controller;

    public AddWatchHandler(MenuOptionController controller) {
        this.controller = controller;
    }

    @Override
    public void handle() {
        controller.addWatch();
    }

    @Override
    public String getMenuDescription() {
        return MENU_OPTION_ADD_WATCH;
    }

}
