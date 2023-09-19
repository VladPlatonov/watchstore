package com.rolex.service;

import com.rolex.model.watches.Watch;
import com.rolex.repository.WatchRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WatchService {

    private final WatchRepository repository;

    public void addWatch(Watch watch) {
        log.info("Watch added: {}", repository.save(watch));
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
