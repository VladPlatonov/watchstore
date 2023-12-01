package com.watch.store.controller;

import static com.watch.store.util.Constants.INVALID_INPUT_MENU_OPTION;
import static com.watch.store.util.Constants.INVALID_INPUT_NUMBER;

import com.watch.store.handler.MenuHandler;
import com.watch.store.model.Color;
import com.watch.store.model.MechanicalWatch;
import com.watch.store.model.QuartzWatch;
import com.watch.store.model.SolarWatch;
import com.watch.store.service.WatchService;
import com.watch.store.view.InputHandler;
import com.watch.store.view.ViewConsole;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


/**
 * The main class responsible for running the interactive watch store menu, handling user input, and
 * displaying menu choices.
 */

public class MenuController {

    private final List<MenuHandler> menuHandlers;
    private final WatchService service;
    private final ViewConsole view;
    private final InputHandler input;

    public MenuController(List<MenuHandler> menuHandlers, WatchService service, ViewConsole view,
        InputHandler input) {
        this.menuHandlers = menuHandlers;
        this.service = service;
        this.view = view;
        this.input = input;
    }

    /**
     * Initializes and runs the watch store menu after the bean is constructed.
     */
    public void runMenu() {
        printMenu();
        initData();
        processUserInput();
    }

    private void processUserInput() {
        Stream.generate(input::readInput)
            .takeWhile(Objects::nonNull)
            .forEach(input -> {
                validMenuOption(input);
                printMenu();
            });
    }

    private void validMenuOption(String input) {
        try {
            int choice = Integer.parseInt(input);
            if (choice < 0 || choice >= menuHandlers.size()) {
                view.printErrorMessage(INVALID_INPUT_MENU_OPTION);
            } else {
                menuHandlers.get(choice).handle();
            }

        } catch (NumberFormatException e) {
            view.printErrorMessage(INVALID_INPUT_NUMBER);
        }
    }

    private void initData() {
        service.addWatch(
            MechanicalWatch.builder().price(BigDecimal.valueOf(100L)).arrivalDate(LocalDate.now())
                .color(Color.BLACK).build());
        service.addWatch(
            MechanicalWatch.builder().price(BigDecimal.valueOf(200L)).arrivalDate(LocalDate.now())
                .color(Color.BLUE).build());
        service.addWatch(
            QuartzWatch.builder().price(BigDecimal.valueOf(300L)).arrivalDate(LocalDate.now())
                .color(Color.BROWN)
                .build());
        service.addWatch(
            QuartzWatch.builder().price(BigDecimal.valueOf(400L)).arrivalDate(LocalDate.now())
                .color(Color.GREY)
                .build());
        service.addWatch(
            SolarWatch.builder().price(BigDecimal.valueOf(500L)).arrivalDate(LocalDate.now())
                .color(Color.ORANGE)
                .build());
        service.addWatch(
            SolarWatch.builder().price(BigDecimal.valueOf(600L)).arrivalDate(LocalDate.now())
                .color(Color.BLUE)
                .build());
    }

    private void printMenu() {
        menuHandlers.stream()
            .map(MenuHandler::getMenuDescription)
            .forEach(view::printMessage);
    }

}
