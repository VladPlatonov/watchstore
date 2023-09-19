package com.rolex.controller;

import com.rolex.model.watches.Watch;
import com.rolex.service.WatchService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WatchController {

    private final WatchService service;

    public void addWatch(Watch watch) {
        service.addWatch(watch);
    }

    public List<Watch> getAllWatches() {
        return service.getAllWatches();
    }

    public Long getTotalPrice() {
        return service.getTotalPrice();
    }

    public List<Watch> sortByPrice() {
        return service.sortByPrice();
    }

    public List<Watch> sortByColor() {
        return service.sortByColor();
    }

    public List<Watch> sortByArrivalDate() {
        return service.sortByArrivalDate();
    }
}
