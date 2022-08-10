package com.alexey.sheblykin.controllers;

import com.alexey.sheblykin.services.CounterService;
import io.swagger.api.CounterApi;
import io.swagger.model.CounterIncrementRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Controller
public class CounterController implements CounterApi {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @Override
    public ResponseEntity<String> createCounter(@Valid Integer count) {
        String id = counterService.saveCounter(count);
        return ResponseEntity.ok(id);
    }

    @Override
    public ResponseEntity<Integer> getCount(@NotNull @Size(max = 10) String counterId) {
        int count = counterService.getCountById(counterId);
        return ResponseEntity.ok(count);
    }

    @Override
    public ResponseEntity<Integer> incrementCount(@Valid CounterIncrementRequest counterRequest) {
        int incrementedCount = counterService
                .incrementAndGetCount(counterRequest.getCounterId(), counterRequest.getIncrementCount());
        return ResponseEntity.ok(incrementedCount);
    }
}
