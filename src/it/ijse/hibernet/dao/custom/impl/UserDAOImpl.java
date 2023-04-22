package it.ijse.hibernet.dao.custom.impl;

import it.ijse.hibernet.dao.custom.UserDAO;
import it.ijse.hibernet.entty.User;
import it.ijse.hibernet.util.FactoryConfiguration;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
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

    public List<User> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(User.class);
        List users = criteria.list();

        ArrayList<User> allUsers = new ArrayList<>(users);

        transaction.commit();
        session.close();
        return allUsers;
    }

    @Override
    public String IdGenerator() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT max (user_ID) FROM User");
        List list = query.list();

        transaction.commit();
        session.close();

        if (list.get(0) == null){
            return "U00-001";
        }else {
            String id = String.valueOf(list.get(0));
            Long resID = Long.parseLong(id.substring(4,id.length()));
            resID++;
            return "U00-"+String.format("%03d", resID);
        }
    }

    @Override
    public ObservableList<User> getAllID() {
        return null;
    }

    public List<User> findUserByName(String name){
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        String sql = "FROM User U WHERE U.user_Name = "+name ;
        Query query = session.createQuery(sql);
        List<User> list = query.list();

        System.out.println(list);

        transaction.commit();
        session.close();

        return null;
    }
}
