package ru.job4j.tasks.model.cars;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            ModelCar one = ModelCar.of("Logan");
            session.save(one);
            ModelCar two = ModelCar.of("Sandero");
            session.save(two);
            ModelCar three = ModelCar.of("Clio");
            session.save(three);
            ModelCar four = ModelCar.of("Megan");
            session.save(four);
            ModelCar five = ModelCar.of("Duster");
            session.save(five);

            MarkaCar reno = MarkaCar.of("Reno");
            reno.addUser(session.load(ModelCar.class, 1));
            reno.addUser(session.load(ModelCar.class, 2));
            reno.addUser(session.load(ModelCar.class, 3));
            reno.addUser(session.load(ModelCar.class, 4));
            reno.addUser(session.load(ModelCar.class, 5));

            session.save(reno);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
