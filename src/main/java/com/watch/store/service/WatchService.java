package com.watch.store.service;

import com.watch.store.model.Watch;
import com.watch.store.repository.WatchRepository;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WatchService {

    private final WatchRepository repository;

    public WatchService(WatchRepository repository) {
        this.repository = repository;
    }

    public Watch addWatch(Watch watch) {
        return repository.save(watch);
    }

    public List<Watch> getAllWatches() {
        return repository.findAll();
    }

    public BigDecimal getTotalPrice() {
        return repository.findAll().stream()
            .map(Watch::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public List<Watch> sortByPrice() {
        return sortBy(Comparator.comparing(Watch::getPrice, BigDecimal::compareTo));
    }

    public List<Watch> sortByColor() {
        return sortBy(Comparator.comparing(Watch::getColor));
    }

    public List<Watch> sortByArrivalDate() {
        return sortBy(Comparator.comparing(Watch::getArrivalDate));
    }

    private List<Watch> sortBy(Comparator<Watch> comparator) {
        return repository.findAll()
            .stream()
            .sorted(comparator)
            .collect(Collectors.toList());
    }

}
