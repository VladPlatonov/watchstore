package com.soft.util;

import com.soft.model.Color;
import com.soft.model.Company;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * A utility class responsible for interacting with the user to gather input related to watch
 * properties.
 */
public class WatchInput {

    private final WatchValidator validator;

    public WatchInput(WatchValidator validator) {
        this.validator = validator;
    }

    /**
     * Asks the user to enter the solar panel value for a watch.
     *
     * @param scanner the Scanner used for reading input data
     * @return the solar panel value as a String
     */
    public String getSolarPanel(Scanner scanner) {
        System.out.println("Please enter watch solar panel: ");
        return scanner.next();
    }

    /**
     * Asks the user to enter the movement value for a watch.
     *
     * @param scanner the Scanner used for reading input data
     * @return the movement value as a String
     */
    public String getMovement(Scanner scanner) {
        System.out.println("Please enter watch movement: ");
        return scanner.next();
    }

    /**
     * Asks the user to enter the price value for a watch, validating the input until a valid price
     * is provided.
     *
     * @param scanner the Scanner used for reading input data
     * @return the valid price value as a Long
     */
    public Long getPrice(Scanner scanner) {
        System.out.println("Please enter watch price: ");
        String priceStr = scanner.next();

        while (validator.isValidPrice(priceStr).isEmpty()) {
            System.out.println("Please enter watch price: ");
            priceStr = scanner.next();
        }

        return Long.parseLong(priceStr);
    }

    /**
     * Asks the user to enter the color value for a watch, validating the input until a valid color
     * is provided.
     *
     * @param scanner the Scanner used for reading input data
     * @return the valid color value as a Color enum constant
     */
    public Color getColor(Scanner scanner) {
        System.out.println(
            Arrays.stream(Color.values()).map(Enum::name)
                .collect(Collectors.joining(", ", "Please enter watch color (", "): ")));
        String color = scanner.next();

        while (validator.isValidColor(color).isEmpty()) {
            System.out.println(
                Arrays.stream(Color.values()).map(Enum::name)
                    .collect(Collectors.joining(", ", "Please enter watch color (", "): ")));
            color = scanner.next();
        }

        return Color.valueOf(color.toUpperCase());
    }

    /**
     * Asks the user to enter the company value for a watch, validating the input until a valid
     * company is provided.
     *
     * @param scanner the Scanner used for reading input data
     * @return the valid company value as a Company enum constant
     */
    public Company getCompany(Scanner scanner) {
        System.out.println(
            Arrays.stream(Company.values()).map(Enum::name)
                .collect(Collectors.joining(", ", "Please enter watch company (", "): ")));
        String company = scanner.next();

        while (validator.isValidCompany(company).isEmpty()) {
            System.out.println(
                Arrays.stream(Company.values()).map(Enum::name)
                    .collect(Collectors.joining(", ", "Please enter watch company (", "): ")));
            company = scanner.next();
        }

        return Company.valueOf(company.toUpperCase());
    }

    /**
     * Asks the user to enter the arrival date for a watch, validating the input until a valid date
     * is provided.
     *
     * @param scanner the Scanner used for reading input data
     * @return the valid arrival date value as a LocalDate object
     */
    public LocalDate getDate(Scanner scanner) {
        System.out.println("Please enter watch arrival date (yyyy-MM-dd): ");
        String valueDate = scanner.next();

        while (validator.isValidDate(valueDate).isEmpty()) {
            System.out.println("Please enter watch arrival date (yyyy-MM-dd): ");
            valueDate = scanner.next();
        }

        return LocalDate.parse(valueDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
