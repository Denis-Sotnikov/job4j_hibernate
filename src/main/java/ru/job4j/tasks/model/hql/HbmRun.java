package ru.job4j.tasks.model.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

//            Candidate one = Candidate.of("Vika", 5, 1500);
//            Candidate two = Candidate.of("Nikolay", 28, 2000);
//            Candidate three = Candidate.of("Nikita", 25, 2500);
//
//            session.save(one);
//            session.save(two);
//            session.save(three);

//            Query query = session.createQuery("from Candidate c where c.id = 1");
//            for (Object st : query.list()) {
//                System.out.println(st);
//            }

//            Query query = session.createQuery("from Candidate c where c.name = 'Nikita'");
//            for (Object st : query.list()) {
//                System.out.println(st);
//            }

//            Query query = session.createQuery(
//                    "update Candidate c set c.name = :newName, c.experience = :newExperience, c.salary = :newSalary where c.id = :fId"
//            );
//            query.setParameter("newName", "Masha");
//            query.setParameter("newExperience", 4);
//            query.setParameter("newSalary", 1700);
//            query.setParameter("fId", 2);
//            query.executeUpdate();

            session.createQuery("delete from Candidate where id = :fId")
                    .setParameter("fId", 3)
                    .executeUpdate();

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}