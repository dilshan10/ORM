package it.ijse.hibernet.dao.custom.impl;

import it.ijse.hibernet.dao.custom.StudentDAO;
import it.ijse.hibernet.entty.Student;
import it.ijse.hibernet.util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    public boolean add(Student entity) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Student entity) throws Exception {
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

        Student student = session.load(Student.class, ID);

        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    public Student find (String id) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Student student = session.get(Student.class, id);

        transaction.commit();
        session.close();
        return student;
    }

    public List<Student> findAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Criteria criteria = session.createCriteria(Student.class);
        List students = criteria.list();

        ArrayList<Student> allStudents = new ArrayList<>(students);

        transaction.commit();
        session.close();
        return allStudents;
    }

    @Override
    public String IdGenerator() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT max (student_ID) FROM Student ");
        List list = query.list();

        transaction.commit();
        session.close();

        if (list.get(0) == null){
            return "S00-001";
        }else {
            String id = String.valueOf(list.get(0));
            Long resID = Long.parseLong(id.substring(4,id.length()));
            resID++;
            return "S00-"+String.format("%03d", resID);
        }
    }

    @Override
    public ObservableList<Student> getAllID() {
        return null;
    }

    public ObservableList<Student> getID() throws Exception{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        Query query = session.createSQLQuery("SELECT student_ID FROM student");
        ObservableList<Student> list = FXCollections.observableArrayList(query.list());

        transaction.commit();
        session.close();
        return list;
    }

}