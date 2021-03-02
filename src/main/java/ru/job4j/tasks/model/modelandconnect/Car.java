package ru.job4j.tasks.model.modelandconnect;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Car {
    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "driver_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "car_id",
                    nullable = false, updatable = false) })
    Set<Driver> drivers = new HashSet<>();
    public Set<Driver> getDrivers() {
        return drivers;
    }
}
