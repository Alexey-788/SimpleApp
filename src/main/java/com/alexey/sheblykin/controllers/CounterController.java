package com.alexey.sheblykin.controllers;

import com.alexey.sheblykin.services.CounterService;
import io.swagger.api.CounterApi;
import io.swagger.model.CounterDto;
import io.swagger.model.CounterIncrementRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RestController
public class CounterController implements CounterApi {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @Override
    public ResponseEntity<String> createCounter(@Valid CounterDto counter) {
        String id = counterService.saveCounter(counter);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> getCount(@NotNull @Size(max = 10) String counterId) {
        int count = counterService.getCountById(counterId);
        return ResponseEntity.ok(count);
    }

    @Override
    public ResponseEntity<Integer> incrementCount(@Valid CounterIncrementRequestDto counterRequest) {
        int incrementedCount = counterService
                .incrementAndGetCount(counterRequest.getCounterId(), counterRequest.getIncrementCount());
        return ResponseEntity.ok(incrementedCount);
    }
}
