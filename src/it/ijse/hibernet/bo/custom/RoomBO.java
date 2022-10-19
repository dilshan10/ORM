package it.ijse.hibernet.bo.custom;

import it.ijse.hibernet.bo.SuperBO;
import it.ijse.hibernet.dto.RoomDTO;
import it.ijse.hibernet.entty.Room;
import it.ijse.hibernet.entty.Student;

import java.util.List;

public interface RoomBO extends SuperBO {
    public boolean add(RoomDTO roomDTO) throws Exception;

    public boolean update(RoomDTO roomDTO) throws Exception;

    public boolean delete(String ID) throws Exception;

    public Room find (String ID) throws Exception;

    public List<Room> findAll() throws Exception;

    public List<Room> getID() throws Exception;

    public String IdGenerator();
}
