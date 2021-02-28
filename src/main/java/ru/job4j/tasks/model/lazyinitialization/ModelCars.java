package ru.job4j.tasks.model.lazyinitialization;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "model_car_lazy")
public class ModelCars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "marka_id")
    private MarkCar markCar;

    public static ModelCars of(String name) {
        ModelCars model = new ModelCars();
        model.name = name;
        return model;
    }

    public ModelCars() {
    }

    public ModelCars(int id) {
        this.id = id;
    }

    public ModelCars(int id, String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModelCars modelCars = (ModelCars) o;
        return id == modelCars.id
                && Objects.equals(name, modelCars.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ModelCar{"
                + "id=" + id
                + ", name='" + name
                + '\''
                + ", markaCar="
                + markCar
                + '}';
    }
}
