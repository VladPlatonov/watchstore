package com.watch.store.controller;

import static com.watch.store.util.Constants.DATE_FORMAT;
import static com.watch.store.util.Constants.ENTER_ARRIVAL_DATE;
import static com.watch.store.util.Constants.ENTER_COLOR;
import static com.watch.store.util.Constants.ENTER_COMPANY;
import static com.watch.store.util.Constants.ENTER_MOVEMENT;
import static com.watch.store.util.Constants.ENTER_PRICE;
import static com.watch.store.util.Constants.ENTER_SOLAR_PANEL;

import com.watch.store.model.Color;
import com.watch.store.model.Company;
import com.watch.store.util.WatchValidator;
import com.watch.store.view.InputHandler;
import com.watch.store.view.ViewConsole;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * A utility class responsible for interacting with the user to gather input related to watch
 * properties.
 */
public class WatchInputController {

    private final WatchValidator validator;
    private final ViewConsole view;
    private final InputHandler input;

    public WatchInputController(WatchValidator validator, ViewConsole view, InputHandler input) {
        this.validator = validator;
        this.view = view;
        this.input = input;
    }

    /**
     * Asks the user to enter the solar panel value for a watch.
     *
     * @return the solar panel value as a String
     */
    public String getSolarPanel() {
        view.printMessage(ENTER_SOLAR_PANEL);
        return input.readInput();
    }

    /**
     * Asks the user to enter the movement value for a watch.
     *
     * @return the movement value as a String
     */
    public String getMovement() {
        view.printMessage(ENTER_MOVEMENT);
        return input.readInput();
    }

    /**
     * Asks the user to enter the price value for a watch, validating the input until a valid price
     * is provided.
     *
     * @return the valid price value as a Long
     */
    public BigDecimal getPrice() {
        String priceStr;

        do {
            view.printMessage(ENTER_PRICE);
            priceStr = input.readInput();
        }
        while (validator.isValidPrice(priceStr).isEmpty());

        return BigDecimal.valueOf(Double.parseDouble(priceStr));
    }

    /**
     * Asks the user to enter the color value for a watch, validating the input until a valid color
     * is provided.
     *
     * @return the valid color value as a Color enum constant
     */
    public Color getColor() {
        String color;
        do {
            view.printMessage(
                Arrays.stream(Color.values()).map(Enum::name)
                    .collect(Collectors.joining(", ", ENTER_COLOR + " (", "): ")));
            color = input.readInput();
        }
        while (validator.isValidColor(color).isEmpty());

        return Color.valueOf(color.toUpperCase());
    }

    /**
     * Asks the user to enter the company value for a watch, validating the input until a valid
     * company is provided.
     *
     * @return the valid company value as a Company enum constant
     */
    public Company getCompany() {
        String company;
        do {
            view.printMessage(
                Arrays.stream(Company.values()).map(Enum::name)
                    .collect(Collectors.joining(", ", ENTER_COMPANY + " (", "): ")));
            company = input.readInput();
        }
        while (validator.isValidCompany(company).isEmpty());

        return Company.valueOf(company.toUpperCase());
    }

    /**
     * Asks the user to enter the arrival date for a watch, validating the input until a valid date
     * is provided.
     *
     * @return the valid arrival date value as a LocalDate object
     */
    public LocalDate getDate() {
        String valueDate;
        do {
            view.printMessage(ENTER_ARRIVAL_DATE);
            valueDate = input.readInput();
        }
        while (validator.isValidDate(valueDate).isEmpty());

        return LocalDate.parse(valueDate, DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

}
