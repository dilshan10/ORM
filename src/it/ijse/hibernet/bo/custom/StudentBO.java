package it.ijse.hibernet.bo.custom;

import it.ijse.hibernet.bo.SuperBO;
import it.ijse.hibernet.dto.StudentDTO;
import it.ijse.hibernet.entty.Room;
import it.ijse.hibernet.entty.Student;

import java.util.List;

public interface StudentBO extends SuperBO {
    public boolean add(StudentDTO studentDTO) throws Exception;

    public boolean update(StudentDTO studentDTO) throws Exception;

    public boolean delete(String ID) throws Exception;

    public Student find (String ID) throws Exception;

    public List<Student> findAll() throws Exception;

    public List<Student> getID() throws Exception ;

    public String IdGenerator();
}
