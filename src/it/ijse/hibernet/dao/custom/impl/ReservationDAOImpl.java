package it.ijse.hibernet.dao.custom.impl;

import it.ijse.hibernet.dao.custom.ReservationDAO;
import it.ijse.hibernet.entty.Reservation;
import it.ijse.hibernet.util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
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

    public List<Reservation> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Reservation.class);
        List reservations = criteria.list();

        ArrayList<Reservation> allReservations = new ArrayList<>(reservations);

        transaction.commit();
        session.close();
        return allReservations;
    }
    public String IdGenerator(){
        Session session =FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT max (res_id) FROM Reservation");
        List list1 = query.list();

        transaction.commit();
        session.close();

        if (list1.get(0) == null){
            return "R00-001";
        }else {
         String id = String.valueOf(list1.get(0));
             Long resID = Long.parseLong(id.substring(4,id.length()));
             resID++;
             return "R00-"+String.format("%03d", resID);
        }
    }

    public ObservableList<Reservation> getAllID(){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery("SELECT res_id FROM Reservation ");
        ObservableList<Reservation> list =FXCollections.observableArrayList( query.list());

        transaction.commit();
        session.close();

        return list;
    }

}
