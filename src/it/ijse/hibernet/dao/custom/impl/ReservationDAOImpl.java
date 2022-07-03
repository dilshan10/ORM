package it.ijse.hibernet.dao.custom.impl;

import it.ijse.hibernet.dao.custom.ReservationDAO;
import it.ijse.hibernet.entty.Reservation;
import it.ijse.hibernet.entty.Student;
import it.ijse.hibernet.util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    public boolean add(Reservation entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Reservation entity) throws Exception {
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

        Reservation reservation = session.load(Reservation.class, ID);

        session.delete(reservation);

        transaction.commit();
        session.close();
        return true;    }

    public Reservation find (String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Reservation reservation = session.get(Reservation.class, id);

        transaction.commit();
        session.close();
        return reservation;
    }

    public ObservableList<Reservation> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Query query = session.createSQLQuery("SELECT * FROM reservation");
        ObservableList<Reservation> list = FXCollections.observableArrayList(query.list());

        transaction.commit();
        session.close();
        return list;
    }
}
