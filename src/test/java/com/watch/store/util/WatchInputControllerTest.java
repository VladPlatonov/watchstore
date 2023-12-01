//package com.watch.store.util;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import com.watch.store.model.Color;
//import com.watch.store.controller.WatchInputController;
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Optional;
//import java.util.Scanner;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class WatchInputControllerTest {
//
//    @Mock
//    private WatchValidator validator;
//
//    private WatchInputController watchInputController;
//
//    private InputStream originalIn;
//
//    @BeforeEach
//    void setUp() {
//        watchInputController = new WatchInputController();
//        originalIn = System.in;
//    }
//
//    @AfterEach
//    void tearDown() {
//        System.setIn(originalIn);
//    }
//
//    @Test
//    void shouldReturnSolarPanel_whenGetSolarPanelIsCalled() {
//        String input = "solar-input";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        String solarPanel = watchInputController.getSolarPanel();
//
//        assertEquals(input, solarPanel);
//    }
//
//    @Test
//    void shouldReturnMovement_whenGetMovementIsCalled() {
//        String input = "movement-input";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//
//        Scanner scanner = new Scanner(System.in);
//
//        String movement = watchInputController.getMovement();
//
//        assertEquals(input, movement);
//    }
//
//    @Test
//    void shouldReturnValidPrice_whenGetPriceIsCalled() {
//        String input = "1000";
//        when(validator.isValidPrice(input)).thenReturn(Optional.of(Long.parseLong(input)));
//
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        BigDecimal price = watchInputController.getPrice();
//
//        assertEquals(Long.parseLong(input), price);
//        verify(validator, times(1)).isValidPrice(input);
//    }
//
//    @Test
//    void shouldReturnValidColor_whenGetColorIsCalled() {
//        String input = "RED";
//        when(validator.isValidColor(input)).thenReturn(Optional.of(Color.RED));
//
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        Scanner scanner = new Scanner(System.in);
//        Color color = watchInputController.getColor(scanner);
//
//        assertEquals(Color.RED, color);
//        verify(validator, times(1)).isValidColor(input);
//    }
//
//    @Test
//    void shouldReturnValidDate_whenGetDateIsCalled() {
//        String input = "2022-01-01";
//        when(validator.isValidDate(input)).thenReturn(
//            Optional.of(LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
//
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        Scanner scanner = new Scanner(System.in);
//        LocalDate date = watchInputController.getDate(scanner);
//
//        assertEquals(LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd")), date);
//        verify(validator, times(1)).isValidDate(input);
//    }
//}
