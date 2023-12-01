package com.watch.store.factory;

import static com.watch.store.util.Constants.QUARTZ_WATCH_TYPE;

import com.watch.store.controller.WatchInputController;
import com.watch.store.model.QuartzWatch;
import com.watch.store.model.Watch;

public class QuartzWatchFactory implements WatchFactory {

    private final WatchInputController controller;

    public QuartzWatchFactory(WatchInputController controller) {
        this.controller = controller;
    }

    @Override
    public String getWatchType() {
        return QUARTZ_WATCH_TYPE;
    }

    @Override
    public Watch createWatch() {
        return QuartzWatch.builder()
            .movement(controller.getMovement())
            .company(controller.getCompany())
            .price(controller.getPrice())
            .color(controller.getColor())
            .arrivalDate(controller.getDate())
            .build();
    }
}
