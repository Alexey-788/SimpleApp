package com.alexey.sheblykin.services;

import com.alexey.sheblykin.entities.CounterEntity;
import com.alexey.sheblykin.repositories.CounterRepository;
import io.swagger.model.CounterDto;
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
    public String saveCounter(CounterDto counterDto) {
        CounterEntity counterEntity = new CounterEntity(counterDto);
        counterRepository.save(counterEntity);
        return counterEntity.getId();
    }

    public int getCountById(String id) {
        CounterEntity counterEntity = counterRepository.getById(id);
        return counterEntity.getCount();
    }

    @Transactional
    public int incrementAndGetCount(String counterId, int incrementCount) {
        counterRepository.incrementCount(counterId, incrementCount);
        CounterEntity counterEntity = counterRepository.getById(counterId);
        return counterEntity.getCount();
    }
}
