package ru.job4j.tasks.model.lazyinitialization;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "marka_car_lazy")
public class MarkCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "markCar")
    private List<ModelCars> modelCarsList = new ArrayList<>();


    public static MarkCar of(String name) {
        MarkCar markCar = new MarkCar();
        markCar.name = name;
        return markCar;
    }

    public MarkCar() {
    }

    public MarkCar(int id) {
        this.id = id;
    }

    public MarkCar(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addCar(ModelCars modelCars) {
        this.modelCarsList.add(modelCars);
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

    public List<ModelCars> getModelCarsList() {
        return modelCarsList;
    }

    public void setModelCarsList(List<ModelCars> modelCarsList) {
        this.modelCarsList = modelCarsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MarkCar markCar = (MarkCar) o;
        return id == markCar.id
                && Objects.equals(name, markCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "MarkaCar{"
                + "id=" + id
                + ", name='" + name
                + '\'' + '}';
    }
}