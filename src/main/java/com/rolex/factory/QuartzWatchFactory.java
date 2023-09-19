package com.rolex.factory;

import com.rolex.model.watches.QuartzWatch;
import com.rolex.model.watches.Watch;
import com.rolex.util.WatchInput;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuartzWatchFactory implements WatchFactory {

    private final WatchInput input;

    @Override
    public String getWatchType() {
        return "Quartz";
    }

    @Override
    public Watch createWatch(Scanner scanner) {
        return QuartzWatch.builder()
            .movement(input.getMovement(scanner))
            .price(input.getPrice(scanner))
            .color(input.getColor(scanner))
            .arrivalDate(input.getDate(scanner))
            .build();
    }
}
