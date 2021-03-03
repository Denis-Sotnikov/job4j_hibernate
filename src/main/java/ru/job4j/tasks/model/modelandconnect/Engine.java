package ru.job4j.tasks.model.modelandconnect;


import javax.persistence.*;

@Entity
@Table(name = "engines")
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    public static Engine of(String name) {
        Engine engine = new Engine();
        engine.name = name;
        return engine;
    }

    public Engine() {
    }

    public Engine(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
