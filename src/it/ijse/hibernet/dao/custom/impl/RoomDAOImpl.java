package it.ijse.hibernet.dao.custom.impl;

import it.ijse.hibernet.dao.custom.RoomDAO;
import it.ijse.hibernet.entty.Room;
import it.ijse.hibernet.util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
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
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Room.class);
        List rooms = criteria.list();

        ArrayList<Room> allRoom = new ArrayList<>(rooms);

        transaction.commit();
        session.close();
        return allRoom;
    }

    @Override
    public String IdGenerator() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT max (room_type_ID) FROM Room");
        List list = query.list();

        transaction.commit();
        session.close();

        if (list.get(0) == null){
            return "RM00-001";
        }else {
            String id = String.valueOf(list.get(0));
            Long resID = Long.parseLong(id.substring(5,id.length()));
            resID++;
            return "RM00-"+String.format("%03d", resID);
        }
    }

    @Override
    public ObservableList<Room> getAllID() {
        return null;
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

    public boolean updateRoomQty(int newQTY,String id){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery("UPDATE Room set Qty=:newQTY where room_type_ID=:id");


        transaction.commit();
        session.close();
        return true;
    }
}
