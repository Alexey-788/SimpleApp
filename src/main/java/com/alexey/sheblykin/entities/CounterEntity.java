package com.alexey.sheblykin.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "counter")
public class CounterEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "counter_id_gen")
    @SequenceGenerator(name = "counter_id_gen", sequenceName = "counter_id_seq")
    private long id;
    private int count;

    public CounterEntity() {
    }

    public CounterEntity(int count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return getId() == that.getId() && getCount() == that.getCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCount());
    }
}
