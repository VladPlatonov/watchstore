package com.rolex.util;

import com.rolex.exception.DateFutureException;
import com.rolex.exception.InvalidPriceNegativeException;
import com.rolex.model.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * A utility class responsible for validating input values related to watch properties.
 */
@Component
public class WatchValidator {

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
                throw new InvalidPriceNegativeException("Invalid price negative, please try again");
            }
            return Optional.of(price);

        } catch (NumberFormatException | InvalidPriceNegativeException e) {
            System.err.println(e.getMessage());
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
            System.err.println("Invalid color, please try again");
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
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            if (parsedDate.isAfter(LocalDate.now())) {
                throw new DateFutureException(
                    "Arrival date can't be in the future. Please enter a valid date.");
            }
            return Optional.of(parsedDate);

        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format. Please use the format yyyy-MM-dd.");
            return Optional.empty();

        } catch (DateFutureException e) {
            System.err.println(e.getMessage());
            return Optional.empty();
        }
    }
}
