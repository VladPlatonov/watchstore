package com.soft.factory;

import com.soft.model.MechanicalWatch;
import com.soft.model.Watch;
import com.soft.util.WatchInput;
import java.util.Scanner;

public class MechanicalWatchFactory implements WatchFactory {

    private final WatchInput input;

    public MechanicalWatchFactory(WatchInput input) {
        this.input = input;
    }

    @Override
    public String getWatchType() {
        return "Mechanical";
    }

    @Override
    public Watch createWatch(Scanner scanner) {
        return MechanicalWatch.builder()
            .movement(input.getMovement(scanner))
            .company(input.getCompany(scanner))
            .price(input.getPrice(scanner))
            .color(input.getColor(scanner))
            .arrivalDate(input.getDate(scanner))
            .build();
    }
}
