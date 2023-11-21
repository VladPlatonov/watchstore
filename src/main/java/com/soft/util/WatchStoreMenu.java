package com.soft.util;

import com.soft.handler.MenuHandler;
import com.soft.model.Color;
import com.soft.model.MechanicalWatch;
import com.soft.model.QuartzWatch;
import com.soft.model.SolarWatch;
import com.soft.service.WatchService;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Stream;


/**
 * The main class responsible for running the interactive watch store menu, handling user input, and
 * displaying menu choices.
 */

public class WatchStoreMenu {

    private final List<MenuHandler> menuHandlers;
    private final WatchService service;

    public WatchStoreMenu(List<MenuHandler> menuHandlers, WatchService service) {
        this.menuHandlers = menuHandlers;
        this.service = service;
    }

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
        service.addWatch(
            MechanicalWatch.builder().price(100L).arrivalDate(LocalDate.now())
                .color(Color.BLACK).build());
        service.addWatch(
            MechanicalWatch.builder().price(200L).arrivalDate(LocalDate.now())
                .color(Color.BLUE).build());
        service.addWatch(
            QuartzWatch.builder().price(300L).arrivalDate(LocalDate.now()).color(Color.BROWN)
                .build());
        service.addWatch(
            QuartzWatch.builder().price(400L).arrivalDate(LocalDate.now()).color(Color.GREY)
                .build());
        service.addWatch(
            SolarWatch.builder().price(500L).arrivalDate(LocalDate.now()).color(Color.ORANGE)
                .build());
        service.addWatch(
            SolarWatch.builder().price(600L).arrivalDate(LocalDate.now()).color(Color.BLUE)
                .build());
    }

    private void printMenu() {
        menuHandlers.stream()
            .map(MenuHandler::getMenuDescription)
            .forEach(System.out::println);
    }

}
