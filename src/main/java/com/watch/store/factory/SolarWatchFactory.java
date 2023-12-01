package com.watch.store.factory;

import static com.watch.store.util.Constants.SOLAR_WATCH_TYPE;

import com.watch.store.controller.WatchInputController;
import com.watch.store.model.SolarWatch;
import com.watch.store.model.Watch;

public class SolarWatchFactory implements WatchFactory {

    private final WatchInputController controller;

    public SolarWatchFactory(WatchInputController controller) {
        this.controller = controller;
    }

    @Override
    public String getWatchType() {
        return SOLAR_WATCH_TYPE;
    }

    @Override
    public Watch createWatch() {
        return SolarWatch.builder()
            .solarPanel(controller.getSolarPanel())
            .company(controller.getCompany())
            .price(controller.getPrice())
            .color(controller.getColor())
            .arrivalDate(controller.getDate())
            .build();
    }
}
