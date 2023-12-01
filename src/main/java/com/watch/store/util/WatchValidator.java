package com.watch.store.util;

import static com.watch.store.util.Constants.DATE_FORMAT;
import static com.watch.store.util.Constants.INVALID_INPUT_ARRIVAL_DATE;
import static com.watch.store.util.Constants.INVALID_INPUT_COLOR;
import static com.watch.store.util.Constants.INVALID_INPUT_COMPANY;
import static com.watch.store.util.Constants.INVALID_INPUT_DATE_FORMAT;
import static com.watch.store.util.Constants.INVALID_INPUT_PRICE_NEGATIVE;

import com.watch.store.exception.DateFutureException;
import com.watch.store.exception.InvalidPriceNegativeException;
import com.watch.store.model.Color;
import com.watch.store.model.Company;
import com.watch.store.view.ViewConsole;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

/**
 * A utility class responsible for validating input values related to watch properties.
 */
public class WatchValidator {

    private final ViewConsole view;

    public WatchValidator(ViewConsole view) {
        this.view = view;
    }

    /**
     * Validates the input price value and returns an Optional containing the parsed long value if
     * the input is valid.
     *
     * @param value the input price value as a String
     * @return an Optional containing the parsed long value if the input is valid, otherwise an
     * empty Optional
     */
    public Optional<Long> isValidPrice(String value) {
        try {
            long price = Long.parseLong(value);
            if (price < 0) {
                throw new InvalidPriceNegativeException(INVALID_INPUT_PRICE_NEGATIVE);
            }
            return Optional.of(price);

        } catch (NumberFormatException | InvalidPriceNegativeException e) {
            view.printErrorMessage(e.getMessage());
            return Optional.empty();
        }
    }

    /**
     * Validates the input color value and returns an Optional containing the Color enum constant if
     * the input is valid.
     *
     * @param value the input color value as a String
     * @return an Optional containing the Color enum constant if the input is valid, otherwise an
     * empty Optional
     */
    public Optional<Color> isValidColor(String value) {
        try {
            return Optional.of(Color.valueOf(value.toUpperCase()));

        } catch (IllegalArgumentException e) {
            view.printErrorMessage(INVALID_INPUT_COLOR);
            return Optional.empty();
        }
    }

    /**
     * Validates the input company value and returns an Optional containing the Company enum
     * constant if the input is valid.
     *
     * @param value the input company value as a String
     * @return an Optional containing the Company enum constant if the input is valid, otherwise an
     * empty Optional
     */
    public Optional<Company> isValidCompany(String value) {
        try {
            return Optional.of(Company.valueOf(value.toUpperCase()));

        } catch (IllegalArgumentException e) {
            view.printErrorMessage(INVALID_INPUT_COMPANY);
            return Optional.empty();
        }
    }

    /**
     * Validates the input date value and returns an Optional containing the parsed LocalDate value
     * if the input is valid.
     *
     * @param value the input date value as a String
     * @return an Optional containing the parsed LocalDate value if the input is valid, otherwise an
     * empty Optional
     */
    public Optional<LocalDate> isValidDate(String value) {
        try {
            LocalDate parsedDate = LocalDate.parse(value,
                DateTimeFormatter.ofPattern(DATE_FORMAT));
            if (parsedDate.isAfter(LocalDate.now())) {
                throw new DateFutureException(INVALID_INPUT_ARRIVAL_DATE);
            }
            return Optional.of(parsedDate);

        } catch (DateTimeParseException e) {
            view.printErrorMessage(INVALID_INPUT_DATE_FORMAT);
            return Optional.empty();

        } catch (DateFutureException e) {
            view.printErrorMessage(e.getMessage());
            return Optional.empty();
        }
    }
}
