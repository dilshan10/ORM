package it.ijse.hibernet.util;

import it.ijse.hibernet.entty.Reservation;
import it.ijse.hibernet.entty.Room;
import it.ijse.hibernet.entty.Student;
import it.ijse.hibernet.entty.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
