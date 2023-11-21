package com.soft.service;

import com.soft.model.Watch;
import com.soft.repository.WatchRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WatchService {

    private final WatchRepository repository;

    public WatchService(WatchRepository repository) {
        this.repository = repository;
    }

    public void addWatch(Watch watch) {
        System.out.printf("Watch added: %s\n", repository.save(watch));
    }

    public List<Watch> getAllWatches() {
        return repository.findAll();
    }

    public Long getTotalPrice() {
        return repository.findAll().stream()
            .mapToLong(Watch::getPrice)
            .sum();
    }

    public List<Watch> sortByPrice() {
        return sortBy(Comparator.comparingDouble(Watch::getPrice));
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
