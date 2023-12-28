package com.watch.store.controller.factory;

import static com.watch.store.util.MessageConstants.MECHANICAL_WATCH_TYPE;

import com.watch.store.controller.WatchInputController;
import com.watch.store.model.MechanicalWatch;
import com.watch.store.model.Watch;

public class MechanicalWatchFactory implements WatchFactory {

    private final WatchInputController controller;

    public MechanicalWatchFactory(WatchInputController controller) {
        this.controller = controller;
    }

    @Override
    public String getWatchType() {
        return MECHANICAL_WATCH_TYPE;
    }

    @Override
    public Watch createWatch() {
        return MechanicalWatch.builder()
            .movement(controller.getMovement())
            .company(controller.getCompany())
            .price(controller.getPrice())
            .color(controller.getColor())
            .arrivalDate(controller.getDate())
            .build();
    }

}
