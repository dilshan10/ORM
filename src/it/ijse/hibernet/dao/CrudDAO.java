package it.ijse.hibernet.dao;

import javafx.collections.ObservableList;

import java.util.List;

public interface CrudDAO<T,ID> extends SuperDAO{
    public boolean add(T entity) throws Exception;

    public boolean update(T entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public T find(ID id) throws Exception;

    public List<T> findAll() throws Exception;

    public String IdGenerator();

    public ObservableList<T> getAllID();


}