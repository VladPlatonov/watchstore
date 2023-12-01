//package com.watch.store.util;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import com.watch.store.model.Color;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Optional;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//
//class WatchValidatorTest {
//
//    private final WatchValidator validator = new WatchValidator();
//
//    @ParameterizedTest
//    @CsvSource({"1000, 1000",
//        "0, 0",
//        "9223372036854775807, 9223372036854775807"})
//    void isValidPrice_valid(String input, long expectedValue) {
//        Optional<Long> result = validator.isValidPrice(input);
//        assertTrue(result.isPresent());
//        assertEquals(expectedValue, result.get());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"-1000", "invalid"})
//    void isValidPrice_invalid(String input) {
//        Optional<Long> result = validator.isValidPrice(input);
//        assertFalse(result.isPresent());
//    }
//
//    @ParameterizedTest
//    @CsvSource({"red, RED",
//        "GREEN, GREEN",
//        "blue, BLUE"})
//    void isValidColor_valid(String input, String expectedColor) {
//        Optional<Color> result = validator.isValidColor(input);
//        assertTrue(result.isPresent());
//        assertEquals(Color.valueOf(expectedColor), result.get());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"invalid", "not-a-color"})
//    void isValidColor_invalid(String input) {
//        Optional<Color> result = validator.isValidColor(input);
//        assertFalse(result.isPresent());
//    }
//
//    @ParameterizedTest
//    @CsvSource({"2022-02-01, 2022-02-01",
//        "1970-01-01, 1970-01-01"})
//    void isValidDate_valid(String input, String expectedDate) {
//        Optional<LocalDate> result = validator.isValidDate(input);
//        assertTrue(result.isPresent());
//        assertEquals(LocalDate.parse(expectedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")), result.get());
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"2023-12-01", "01-02-2022"})
//    void isValidDate_invalid(String input) {
//        Optional<LocalDate> result = validator.isValidDate(input);
//        assertFalse(result.isPresent());
//    }
//}
