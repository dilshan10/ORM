package it.ijse.hibernet.bo.custom.impl;


import it.ijse.hibernet.bo.custom.StudentBO;
import it.ijse.hibernet.dao.DAOFactory;
import it.ijse.hibernet.dao.DAOType;
import it.ijse.hibernet.dao.custom.impl.StudentDAOImpl;
import it.ijse.hibernet.dto.StudentDTO;
import it.ijse.hibernet.entty.Student;

import java.util.List;

public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO = DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public boolean add(StudentDTO studentDTO) throws Exception {
        return studentDAO.add(new Student(
                studentDTO.getStudent_ID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact_no(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean update(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(
                studentDTO.getStudent_ID(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact_no(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return studentDAO.delete(ID);
    }

    @Override
    public Student find(String ID) throws Exception {
        return studentDAO.find(ID);
    }

    @Override
    public List<Student> findAll() throws Exception {
        return studentDAO.findAll();
    }

    @Override
    public List<Student> getID() throws Exception {
        return studentDAO.getID();
    }
}
