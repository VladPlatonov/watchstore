package com.watch.store;

import com.watch.store.controller.MenuController;
import com.watch.store.controller.MenuOptionController;
import com.watch.store.controller.WatchInputController;
import com.watch.store.model.factory.MechanicalWatchFactory;
import com.watch.store.model.factory.QuartzWatchFactory;
import com.watch.store.model.factory.SolarWatchFactory;
import com.watch.store.model.factory.WatchFactory;
import com.watch.store.controller.handler.AddWatchHandler;
import com.watch.store.controller.handler.MenuHandler;
import com.watch.store.controller.handler.ShowAllWatchesHandler;
import com.watch.store.controller.handler.ShowTotalPriceHandler;
import com.watch.store.controller.handler.SortWatchesByArrivalDateHandler;
import com.watch.store.controller.handler.SortWatchesByColorHandler;
import com.watch.store.controller.handler.SortWatchesByPriceHandler;
import com.watch.store.repository.WatchRepository;
import com.watch.store.service.WatchService;
import com.watch.store.model.validator.WatchValidator;
import com.watch.store.view.InputHandler;
import com.watch.store.view.View;
import java.util.List;

public class WatchStoreApplication {

    public static void main(String[] args) {
        View view = new View();
        InputHandler input = new InputHandler();
        WatchRepository repository = new WatchRepository();
        WatchService service = new WatchService(repository);
        WatchValidator validator = new WatchValidator(view);

        List<WatchFactory> factories = List.of(
            new MechanicalWatchFactory(new WatchInputController(validator, view, input)),
            new QuartzWatchFactory(new WatchInputController(validator, view, input)),
            new SolarWatchFactory(new WatchInputController(validator, view, input))
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
