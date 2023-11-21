package com.soft.factory;

import com.soft.model.SolarWatch;
import com.soft.model.Watch;
import com.soft.util.WatchInput;
import java.util.Scanner;

public class SolarWatchFactory implements WatchFactory {

    private final WatchInput input;

    public SolarWatchFactory(WatchInput input) {
        this.input = input;
    }

    @Override
    public String getWatchType() {
        return "Solar";
    }

    @Override
    public Watch createWatch(Scanner scanner) {
        return SolarWatch.builder()
            .solarPanel(input.getSolarPanel(scanner))
            .company(input.getCompany(scanner))
            .price(input.getPrice(scanner))
            .color(input.getColor(scanner))
            .arrivalDate(input.getDate(scanner))
            .build();
    }
}
