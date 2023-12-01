package com.watch.store.handler;

import static com.watch.store.util.Constants.MENU_OPTION_SORT_WATCHES_BY_PRICE;

import com.watch.store.controller.MenuOptionController;

/**
 * A menu handler that sorts watches by price.
 */
public class SortWatchesByPriceHandler implements MenuHandler {

    private final MenuOptionController controller;

    public SortWatchesByPriceHandler(MenuOptionController controller) {
        this.controller = controller;
    }

    @Override
    public void handle() {
        controller.sortWatchesByPrice();
    }

    @Override
    public String getMenuDescription() {
        return MENU_OPTION_SORT_WATCHES_BY_PRICE;
    }

}
