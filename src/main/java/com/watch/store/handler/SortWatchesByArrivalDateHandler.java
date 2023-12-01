package com.watch.store.handler;

import static com.watch.store.util.Constants.MENU_OPTION_SORT_WATCHES_BY_ARRIVAL_DATE;

import com.watch.store.controller.MenuOptionController;

/**
 * A menu handler that sorts watches by arrival date.
 */
public class SortWatchesByArrivalDateHandler implements MenuHandler {

    private final MenuOptionController controller;

    public SortWatchesByArrivalDateHandler(MenuOptionController controller) {
        this.controller = controller;
    }

    @Override
    public void handle() {
        controller.sortWatchesByArrivalDate();
    }

    @Override
    public String getMenuDescription() {
        return MENU_OPTION_SORT_WATCHES_BY_ARRIVAL_DATE;
    }
}
