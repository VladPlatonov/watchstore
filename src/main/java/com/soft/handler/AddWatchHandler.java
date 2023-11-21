package com.soft.handler;

import com.soft.factory.WatchFactory;
import com.soft.service.WatchService;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * A menu handler that adds a watch.
 */
public class AddWatchHandler implements MenuHandler {

    private final WatchService service;
    private final List<WatchFactory> factories;

    public AddWatchHandler(List<WatchFactory> factories, WatchService service) {
        this.service = service;
        this.factories = factories;
    }

    @Override
    public void handle() {
        Scanner scanner = new Scanner(System.in);
        String title = factories.stream().map(WatchFactory::getWatchType)
            .collect(Collectors.joining(", ", "Add watch\nPlease enter watch type (", "):\n"));
        System.out.println(title);
        String watchType = scanner.next();

        factories.stream()
            .filter(factory -> factory.getWatchType().equalsIgnoreCase(watchType))
            .findFirst()
            .ifPresentOrElse(factory ->
                    service.addWatch(factory.createWatch(scanner)),
                () -> System.err.println("Invalid watch type"));

    }

    @Override
    public String getMenuDescription() {
        return "6. Add watch";
    }

}
