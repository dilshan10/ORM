package it.ijse.hibernet.dao.custom.impl;

import it.ijse.hibernet.dao.custom.UserDAO;
import it.ijse.hibernet.entty.Reservation;
import it.ijse.hibernet.entty.Student;
import it.ijse.hibernet.entty.User;
import it.ijse.hibernet.util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    public boolean add(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(User entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(String ID) throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.load(User.class, ID);

        session.delete(user);

        transaction.commit();
        session.close();
        return true;
    }

    public User find (String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        User user = session.get(User.class, id);

        transaction.commit();
        session.close();
        return user;
    }

    public ObservableList<User> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Query query = session.createSQLQuery("SELECT * FROM user");
        ObservableList<User> list = FXCollections.observableArrayList(query.list());

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String IdGenerator() {
        return null;
    }
}
