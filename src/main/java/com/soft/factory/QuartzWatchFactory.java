package com.soft.factory;

import com.soft.model.QuartzWatch;
import com.soft.model.Watch;
import com.soft.util.WatchInput;
import java.util.Scanner;

public class QuartzWatchFactory implements WatchFactory {

    private final WatchInput input;

    public QuartzWatchFactory(WatchInput input) {
        this.input = input;
    }

    @Override
    public String getWatchType() {
        return "Quartz";
    }

    @Override
    public Watch createWatch(Scanner scanner) {
        return QuartzWatch.builder()
            .movement(input.getMovement(scanner))
            .company(input.getCompany(scanner))
            .price(input.getPrice(scanner))
            .color(input.getColor(scanner))
            .arrivalDate(input.getDate(scanner))
            .build();
    }
}
