package ru.job4j.tasks.model.hql;

import javax.persistence.*;

@Entity
@Table(name = "vacancies")
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    public static Vacancy of(String description) {
        Vacancy vacancy = new Vacancy();
        vacancy.description = description;
        return vacancy;
    }

    public Vacancy() {
    }

    public Vacancy(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Vacancy{"
                + "id=" + id
                + ", description='" + description
                + '\''
                + '}';
    }
}
