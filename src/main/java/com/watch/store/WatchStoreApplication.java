package com.watch.store;

import com.watch.store.controller.MenuController;
import com.watch.store.controller.MenuOptionController;
import com.watch.store.controller.WatchInputController;
import com.watch.store.controller.factory.MechanicalWatchFactory;
import com.watch.store.controller.factory.QuartzWatchFactory;
import com.watch.store.controller.factory.SolarWatchFactory;
import com.watch.store.controller.factory.WatchFactory;
import com.watch.store.controller.handler.menu.AddWatchHandler;
import com.watch.store.controller.handler.menu.MenuHandler;
import com.watch.store.controller.handler.menu.ShowAllWatchesHandler;
import com.watch.store.controller.handler.menu.ShowTotalPriceHandler;
import com.watch.store.controller.handler.menu.SortWatchesByArrivalDateHandler;
import com.watch.store.controller.handler.menu.SortWatchesByColorHandler;
import com.watch.store.controller.handler.menu.SortWatchesByPriceHandler;
import com.watch.store.controller.handler.RetrieveDataHandler;
import com.watch.store.repository.WatchRepository;
import com.watch.store.service.WatchService;
import com.watch.store.view.InputHandler;
import com.watch.store.view.View;
import java.util.List;

public class WatchStoreApplication {

    public static void main(String[] args) {
        View view = new View();
        InputHandler input = new InputHandler();
        WatchRepository repository = new WatchRepository();
        WatchService service = new WatchService(repository);
        RetrieveDataHandler retrieveDataHandler = new RetrieveDataHandler(view);

        List<WatchFactory> factories = List.of(
            new MechanicalWatchFactory(new WatchInputController(retrieveDataHandler, view, input)),
            new QuartzWatchFactory(new WatchInputController(retrieveDataHandler, view, input)),
            new SolarWatchFactory(new WatchInputController(retrieveDataHandler, view, input))
        );

        MenuOptionController menuOptionController = new MenuOptionController(service, view, input,
            factories);

        List<MenuHandler> handlers = List.of(
            new ShowAllWatchesHandler(menuOptionController),
            new ShowTotalPriceHandler(menuOptionController),
            new SortWatchesByArrivalDateHandler(menuOptionController),
            new SortWatchesByColorHandler(menuOptionController),
            new SortWatchesByPriceHandler(menuOptionController),
            new AddWatchHandler(menuOptionController)
        );

        MenuController menu = new MenuController(handlers, service, view, input);
        menu.runMenu();
    }

}
