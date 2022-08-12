package com.alexey.sheblykin.services;

import com.alexey.sheblykin.entities.CounterEntity;
import com.alexey.sheblykin.repositories.CounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CounterService {

    private final CounterRepository counterRepository;

    @Autowired
    public CounterService(CounterRepository counterRepository) {
        this.counterRepository = counterRepository;
    }

    /**
     * @return id of saved {@link CounterEntity}
     */
    public String saveCounter(int count) {
        CounterEntity counterEntity = new CounterEntity(count);
        counterRepository.save(counterEntity);
        return String.valueOf(counterEntity.getId());
    }

    public int getCountById(String id) {
        return getCountById(Long.parseLong(id));
    }

    public int getCountById(long id) {
        CounterEntity counterEntity = counterRepository.getById(id);
        return counterEntity.getCount();
    }

    @Transactional
    public int incrementAndGetCount(String counterId, int incrementCount) {
        return incrementAndGetCount(Long.parseLong(counterId), incrementCount);
    }

    @Transactional
    public int incrementAndGetCount(long counterId, int incrementCount) {
        counterRepository.incrementCount(counterId, incrementCount);
        CounterEntity counterEntity = counterRepository.getById(counterId);
        return counterEntity.getCount();
    }
}
