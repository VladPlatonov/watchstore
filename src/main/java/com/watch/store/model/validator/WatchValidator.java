package com.watch.store.model.validator;

import static com.watch.store.util.MessageConstants.DATE_FORMAT;
import static com.watch.store.util.MessageConstants.INVALID_INPUT_ARRIVAL_DATE;
import static com.watch.store.util.MessageConstants.INVALID_INPUT_COLOR;
import static com.watch.store.util.MessageConstants.INVALID_INPUT_COMPANY;
import static com.watch.store.util.MessageConstants.INVALID_INPUT_DATE_FORMAT;
import static com.watch.store.util.MessageConstants.INVALID_INPUT_PRICE_NEGATIVE;

import com.watch.store.model.Color;
import com.watch.store.model.Company;
import com.watch.store.view.View;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

/**
 * A utility class responsible for validating input values related to watch properties.
 */
public class WatchValidator {

    private final View view;

    public WatchValidator(View view) {
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
    public Optional<BigDecimal> isValidPrice(String value) {
        try {
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(value));
            if (price.compareTo(BigDecimal.ZERO) < 0) {
                view.printErrorMessage(INVALID_INPUT_PRICE_NEGATIVE);
                return Optional.empty();
            }
            return Optional.of(price);
        } catch (NumberFormatException e) {
            view.printErrorMessage(e.getMessage());
        }
        return Optional.empty();
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
        }
        return Optional.empty();
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
        }
        return Optional.empty();
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
            LocalDate parsedDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(DATE_FORMAT));

            if (parsedDate.isAfter(LocalDate.now())) {
                view.printErrorMessage(INVALID_INPUT_ARRIVAL_DATE);
                return Optional.empty();
            }
            return Optional.of(parsedDate);
        } catch (DateTimeParseException e) {
            view.printErrorMessage(INVALID_INPUT_DATE_FORMAT);
        }
        return Optional.empty();
    }
}
