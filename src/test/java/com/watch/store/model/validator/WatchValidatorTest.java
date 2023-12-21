package com.watch.store.model.validator;

import static com.watch.store.util.MessageConstants.INVALID_INPUT_COLOR;
import static com.watch.store.util.MessageConstants.INVALID_INPUT_COMPANY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.watch.store.model.Color;
import com.watch.store.model.Company;
import com.watch.store.view.View;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WatchValidatorTest {

    @Mock
    private View view;
    @InjectMocks
    private WatchValidator validator;

    @Test
    void shouldReturnEmptyOptional_whenPriceIsInvalid() {
        Optional<BigDecimal> result = validator.isValidPrice("testInput");

        verify(view).printErrorMessage(anyString());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnValidPrice_whenPriceIsValid() {
        Optional<BigDecimal> result = validator.isValidPrice("300");

        verify(view, times(0)).printErrorMessage(anyString());
        assertEquals(BigDecimal.valueOf(300.0), result.orElseThrow());
    }

    @Test
    void shouldReturnEmptyOptional_whenColorIsInvalid() {
        Optional<Color> result = validator.isValidColor("testInput");

        verify(view).printErrorMessage(INVALID_INPUT_COLOR);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnValidColor_whenColorIsValid() {
        Optional<Color> result = validator.isValidColor("blue");

        verify(view, times(0)).printErrorMessage(anyString());
        assertEquals(Color.BLUE, result.orElseThrow());
    }

    @Test
    void shouldReturnEmptyOptional_whenCompanyIsInvalid() {
        Optional<Company> result = validator.isValidCompany("testInput");

        verify(view).printErrorMessage(INVALID_INPUT_COMPANY);
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnValidCompany_whenCompanyIsValid() {
        Optional<Company> result = validator.isValidCompany("ROLEX");

        verify(view, times(0)).printErrorMessage(anyString());
        assertEquals(Company.ROLEX, result.orElseThrow());
    }

    @Test
    void shouldReturnEmptyOptional_whenDateIsInvalid() {
        Optional<LocalDate> result = validator.isValidDate("testInput");

        verify(view).printErrorMessage(anyString());
        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnValidDate_whenDateIsValid() {
        Optional<LocalDate> result = validator.isValidDate("2022-01-01");

        verify(view, times(0)).printErrorMessage(anyString());
        assertEquals(LocalDate.parse("2022-01-01"), result.orElseThrow());
    }
}
