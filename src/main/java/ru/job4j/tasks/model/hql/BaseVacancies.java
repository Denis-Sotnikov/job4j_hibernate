package ru.job4j.tasks.model.hql;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "baseVacancies")
public class BaseVacancies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vacancy> vacancies = new ArrayList<>();

    public static BaseVacancies of(List<Vacancy> vacancies) {
        BaseVacancies baseVacancies = new BaseVacancies();
        baseVacancies.vacancies = vacancies;
        return baseVacancies;
    }

    public BaseVacancies() {
    }

    public BaseVacancies(int id, List<Vacancy> vacancies) {
        this.id = id;
        this.vacancies = vacancies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    @Override
    public String toString() {
        return "BaseVacancies{"
                + "id=" + id
                + ", vacancies="
                + vacancies
                + '}';
    }
}
