package com.rolex.factory;

import com.rolex.model.watches.SolarWatch;
import com.rolex.model.watches.Watch;
import com.rolex.util.WatchInput;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SolarWatchFactory implements WatchFactory {

    private final WatchInput input;

    @Override
    public String getWatchType() {
        return "Solar";
    }

    @Override
    public Watch createWatch(Scanner scanner) {
        return SolarWatch.builder()
            .solarPanel(input.getSolarPanel(scanner))
            .price(input.getPrice(scanner))
            .color(input.getColor(scanner))
            .arrivalDate(input.getDate(scanner))
            .build();
    }
}
