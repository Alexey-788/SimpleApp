package com.alexey.sheblykin.entities;

import io.swagger.model.CounterDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity(name = "counter")
public class CounterEntity {

    @Id
    private String id;
    private int count;

    public CounterEntity() {
    }

    public CounterEntity(String id, int count) {
        this.id = id;
        this.count = count;
    }

    public CounterEntity(CounterDto counterDto) {
        this.id = counterDto.getId();
        this.count = counterDto.getCount();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounterEntity that = (CounterEntity) o;
        return getCount() == that.getCount() && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCount());
    }
}
