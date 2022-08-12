package com.alexey.sheblykin.repositories;

import com.alexey.sheblykin.entities.CounterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CounterRepository extends JpaRepository<CounterEntity, String> {

    @Transactional
    @Modifying
    @Query("UPDATE counter c SET c.count = c.count + :incrementCount WHERE c.id = :counterId")
    void incrementCount(String counterId, int incrementCount);
}
