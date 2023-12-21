package com.watch.store.controller;

import static com.watch.store.util.MessageConstants.DATE_FORMAT;
import static com.watch.store.util.MessageConstants.ENTER_ARRIVAL_DATE;
import static com.watch.store.util.MessageConstants.ENTER_COLOR;
import static com.watch.store.util.MessageConstants.ENTER_COMPANY;
import static com.watch.store.util.MessageConstants.ENTER_MOVEMENT;
import static com.watch.store.util.MessageConstants.ENTER_PRICE;
import static com.watch.store.util.MessageConstants.ENTER_SOLAR_PANEL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.watch.store.model.Color;
import com.watch.store.model.Company;
import com.watch.store.model.validator.WatchValidator;
import com.watch.store.view.InputHandler;
import com.watch.store.view.View;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class WatchInputControllerTest {

    @Mock
    private WatchValidator validator;
    @Mock
    private View view;
    @Mock
    private InputHandler input;
    @InjectMocks
    private WatchInputController controller;

    @Test
    void shouldReturnSolarPanel_whenGetSolarPanelCalled() {
        when(input.readInput()).thenReturn("testInput");

        String result = controller.getSolarPanel();

        verify(view).printMessage(ENTER_SOLAR_PANEL);
        verify(input).readInput();
        assertEquals("testInput", result);
    }

    @Test
    void shouldReturnMovement_whenGetMovementCalled() {
        when(input.readInput()).thenReturn("testInput");

        String result = controller.getMovement();

        verify(view).printMessage(ENTER_MOVEMENT);
        verify(input).readInput();
        assertEquals("testInput", result);
    }

    @Test
    void shouldReturnPrice_whenGetPriceCalled() {
        when(input.readInput()).thenReturn("500");
        when(validator.isValidPrice("500")).thenReturn(Optional.of(BigDecimal.valueOf(500)));

        BigDecimal result = controller.getPrice();

        verify(view).printMessage(ENTER_PRICE);
        verify(input, times(1)).readInput();
        assertEquals(BigDecimal.valueOf(500.0), result);
    }

    @Test
    void shouldReturnColor_whenGetColorCalled() {
        when(input.readInput()).thenReturn("BLUE");
        when(validator.isValidColor("BLUE")).thenReturn(Optional.of(Color.BLUE));

        Color result = controller.getColor();

        verify(view).printMessage(Arrays.stream(Color.values()).map(Enum::name)
            .collect(Collectors.joining(", ", ENTER_COLOR + " (", "): ")));
        verify(input, times(1)).readInput();
        assertEquals(Color.BLUE, result);
    }

    @Test
    void shouldReturnCorrectCompany_whenGetCompany() {
        when(input.readInput()).thenReturn("ROLEX");
        when(validator.isValidCompany("ROLEX")).thenReturn(Optional.of(Company.ROLEX));

        Company result = controller.getCompany();

        verify(view).printMessage(
            Arrays.stream(Company.values()).map(Enum::name)
                .collect(Collectors.joining(", ", ENTER_COMPANY + " (", "): ")));
        verify(input, times(1)).readInput();
        assertEquals(Company.ROLEX, result);
    }

    @Test
    void shouldReturnDate_whenGetDateCalled() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_FORMAT);
        String dateStr = "2020-10-10";
        when(input.readInput()).thenReturn(dateStr);
        when(validator.isValidDate(dateStr)).thenReturn(Optional.of(LocalDate.parse(dateStr, dtf)));

        LocalDate result = controller.getDate();

        verify(view).printMessage(ENTER_ARRIVAL_DATE);
        verify(input, times(1)).readInput();
        assertEquals(LocalDate.parse(dateStr, dtf), result);
    }

}
