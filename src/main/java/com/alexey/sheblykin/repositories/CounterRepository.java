package com.alexey.sheblykin.repositories;

import com.alexey.sheblykin.entities.CounterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CounterRepository extends JpaRepository<CounterEntity, Long> {
}
