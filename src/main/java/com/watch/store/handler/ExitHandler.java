package com.watch.store.handler;

import static com.watch.store.util.Constants.MENU_OPTION_EXIT;

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
        return MENU_OPTION_EXIT;
    }

}
