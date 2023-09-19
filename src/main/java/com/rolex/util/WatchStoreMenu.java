package com.rolex.util;

import com.rolex.controller.WatchController;
import com.rolex.handler.MenuHandler;
import com.rolex.model.Color;
import com.rolex.model.watches.MechanicalWatch;
import com.rolex.model.watches.QuartzWatch;
import com.rolex.model.watches.SolarWatch;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


/**
 * The main class responsible for running the interactive watch store menu, handling user input, and
 * displaying menu choices.
 */
@Component
@RequiredArgsConstructor
public class WatchStoreMenu {

    private final List<MenuHandler> menuHandlers;
    private final WatchController controller;

    /**
     * Initializes and runs the watch store menu after the bean is constructed.
     */
    public void runMenu() {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        initData();
        processUserInput(scanner);
    }

    /**
     * Processes user input and makes appropriate calls to menu handlers.
     *
     * @param scanner the Scanner used for reading input data
     */
    private void processUserInput(Scanner scanner) {
        Stream.generate(scanner::next)
            .takeWhile(Objects::nonNull)
            .forEach(input -> {
                try {
                    int choice = Integer.parseInt(input);
                    if (choice < 0 || choice >= menuHandlers.size()) {
                        System.err.println("Invalid input, please enter a correct number menu");
                    } else {
                        menuHandlers.get(choice).handle();
                    }

                } catch (NumberFormatException e) {
                    System.err.println("Invalid input, please enter a number");
                }
                printMenu();
            });
    }

    private void initData() {
        controller.addWatch(
            MechanicalWatch.builder().price(100L).arrivalDate(LocalDate.now())
                .color(Color.BLACK).build());
        controller.addWatch(
            MechanicalWatch.builder().price(200L).arrivalDate(LocalDate.now())
                .color(Color.BLUE).build());
        controller.addWatch(
            QuartzWatch.builder().price(300L).arrivalDate(LocalDate.now()).color(Color.BROWN)
                .build());
        controller.addWatch(
            QuartzWatch.builder().price(400L).arrivalDate(LocalDate.now()).color(Color.GREY)
                .build());
        controller.addWatch(
            SolarWatch.builder().price(500L).arrivalDate(LocalDate.now()).color(Color.ORANGE)
                .build());
        controller.addWatch(
            SolarWatch.builder().price(600L).arrivalDate(LocalDate.now()).color(Color.BLUE)
                .build());
    }

    private void printMenu() {
        menuHandlers.stream()
            .map(MenuHandler::getMenuDescription)
            .forEach(System.out::println);
    }

}
