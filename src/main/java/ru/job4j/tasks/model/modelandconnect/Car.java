package ru.job4j.tasks.model.modelandconnect;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK"))
    private Engine engine;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "history_owner", joinColumns = {
            @JoinColumn(name = "drivers_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "cars_id", nullable = false, updatable = false) })

    Set<Driver> drivers = new HashSet<>();
    public Set<Driver> getDrivers() {
        return drivers;
    }

    private String marka;
    private String model;

    static Car of(Engine engine, String marka, String model) {
        Car car = new Car();
        car.engine = engine;
        car.marka = marka;
        car.model =  model;
        return car;
    }

    static Car of(Engine engine, String marka, String model, Set<Driver> drivers) {
        Car car = new Car();
        car.engine = engine;
        car.marka = marka;
        car.model =  model;
        car.drivers = drivers;
        return car;
    }

    public Car() {
    }

    public Car(int id, Engine engine, Set<Driver> drivers) {
        this.id = id;
        this.engine = engine;
        this.drivers = drivers;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDrivers(Set<Driver> drivers) {
        this.drivers = drivers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
