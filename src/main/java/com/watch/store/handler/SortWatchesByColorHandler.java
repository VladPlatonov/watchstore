package com.watch.store.handler;

import static com.watch.store.util.Constants.MENU_OPTION_SORT_WATCHES_BY_COLOR;

import com.watch.store.controller.MenuOptionController;

/**
 * A menu handler that shows all watches.
 */
public class SortWatchesByColorHandler implements MenuHandler {

    private final MenuOptionController controller;

    public SortWatchesByColorHandler(MenuOptionController controller) {
        this.controller = controller;
    }

    @Override
    public void handle() {
        controller.sortWatchesByColor();
    }

    @Override
    public String getMenuDescription() {
        return MENU_OPTION_SORT_WATCHES_BY_COLOR;
    }

}
