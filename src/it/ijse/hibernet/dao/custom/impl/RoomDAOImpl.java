package it.ijse.hibernet.dao.custom.impl;

import it.ijse.hibernet.dao.custom.RoomDAO;
import it.ijse.hibernet.entty.Reservation;
import it.ijse.hibernet.entty.Room;
import it.ijse.hibernet.entty.Student;
import it.ijse.hibernet.util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    public boolean add(Room entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Room entity) throws Exception {
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

        Room room = session.load(Room.class, ID);

        session.delete(room);

        transaction.commit();
        session.close();
        return true;
    }

    public Room find (String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Room room = session.get(Room.class, id);

        transaction.commit();
        session.close();
        return room;
    }

    public List<Room> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Query query = session.createSQLQuery("SELECT * FROM room");
        List<Room> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public String IdGenerator() {
        return "RM00-001";
    }

    public ObservableList<Room> getID() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Query query = session.createSQLQuery("SELECT room_type_ID FROM room");
        ObservableList<Room> list = FXCollections.observableArrayList(query.list());

        transaction.commit();
        session.close();
        return list;
    }
}
