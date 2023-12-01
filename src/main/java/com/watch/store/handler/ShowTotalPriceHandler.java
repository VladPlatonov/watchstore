package com.watch.store.handler;

import static com.watch.store.util.Constants.MENU_OPTION_SHOW_TOTAL_PRICE;

import com.watch.store.controller.MenuOptionController;

/**
 * A menu handler that shows the total price of all watches.
 */
public class ShowTotalPriceHandler implements MenuHandler {

    private final MenuOptionController controller;

    public ShowTotalPriceHandler(MenuOptionController controller) {
        this.controller = controller;
    }

    @Override
    public void handle() {
        controller.showTotalPrice();
    }

    @Override
    public String getMenuDescription() {
        return MENU_OPTION_SHOW_TOTAL_PRICE;
    }
}
