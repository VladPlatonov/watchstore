package com.rolex.handler;

import com.rolex.controller.WatchController;
import com.rolex.factory.WatchFactory;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(6)
@RequiredArgsConstructor
public class AddWatchHandler implements MenuHandler {

    private final WatchController controller;
    private final List<WatchFactory> factories;

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
                    controller.addWatch(factory.createWatch(scanner)),
                () -> System.err.println("Invalid watch type"));

    }

    @Override
    public String getMenuDescription() {
        return "6. Add watch";
    }

}
