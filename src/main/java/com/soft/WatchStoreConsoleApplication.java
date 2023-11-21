package com.soft;

import com.soft.factory.MechanicalWatchFactory;
import com.soft.factory.QuartzWatchFactory;
import com.soft.factory.SolarWatchFactory;
import com.soft.factory.WatchFactory;
import com.soft.handler.AddWatchHandler;
import com.soft.handler.ExitHandler;
import com.soft.handler.MenuHandler;
import com.soft.handler.ShowAllWatchesHandler;
import com.soft.handler.ShowTotalPriceHandler;
import com.soft.handler.SortWatchesByArrivalDateHandler;
import com.soft.handler.SortWatchesByColorHandler;
import com.soft.handler.SortWatchesByPriceHandler;
import com.soft.repository.WatchRepository;
import com.soft.service.WatchService;
import com.soft.util.WatchInput;
import com.soft.util.WatchStoreMenu;
import com.soft.util.WatchValidator;
import java.util.List;

public class WatchStoreConsoleApplication {


    public static void main(String[] args) {
        WatchRepository repository = new WatchRepository();
        WatchValidator validator = new WatchValidator();
        WatchService service = new WatchService(repository);

        List<WatchFactory> factories = List.of(
            new MechanicalWatchFactory(new WatchInput(validator)),
            new QuartzWatchFactory(new WatchInput(validator)),
            new SolarWatchFactory(new WatchInput(validator))
        );

        List<MenuHandler> handlers = List.of(
            new ExitHandler(),
            new ShowAllWatchesHandler(service),
            new ShowTotalPriceHandler(service),
            new SortWatchesByArrivalDateHandler(service),
            new SortWatchesByColorHandler(service),
            new SortWatchesByPriceHandler(service),
            new AddWatchHandler(factories, service)
        );

        WatchStoreMenu menu = new WatchStoreMenu(handlers, service);
        menu.runMenu();
    }

}
