package ru.job4j.tasks.model.hql;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int experience;
    private int salary;

    @OneToOne
    @JoinColumn(name = "baseVacancies_id", foreignKey = @ForeignKey(name = "BASEVACANCIES_ID_FK"))
    private BaseVacancies baseVacancies;

    public static Candidate of(String name, int experience, int salary, BaseVacancies baseVacancies) {
        Candidate candidate = new Candidate();
        candidate.name = name;
        candidate.experience = experience;
        candidate.salary = salary;
        candidate.baseVacancies = baseVacancies;
        return candidate;
    }

    public Candidate() {
    }

    public Candidate(int id, String name, int experience, int salary) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.salary = salary;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Candidate candidate = (Candidate) o;
        return id == candidate.id
                && salary == candidate.salary
                && Objects.equals(name, candidate.name)
                && Objects.equals(experience, candidate.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, experience, salary);
    }

    @Override
    public String toString() {
        return "Candidate{"
                + "id=" + id
                + ", name='" + name
                + '\'' + ", experience=" + experience
                + ", salary=" + salary
                + ", baseVacancies=" + baseVacancies
                + '}';
    }
}
