package it.ijse.hibernet.bo.custom;

import it.ijse.hibernet.bo.SuperBO;
import it.ijse.hibernet.dto.ReservationDTO;
import it.ijse.hibernet.entty.Reservation;
import it.ijse.hibernet.entty.Room;
import it.ijse.hibernet.entty.Student;
import javafx.collections.ObservableList;

import java.util.List;

public interface ReservationBO extends SuperBO {
    public boolean add(ReservationDTO reservationDTO) throws Exception;

    public boolean update(ReservationDTO reservationDTO) throws Exception;

    public boolean delete(String ID) throws Exception;

    public Reservation find (String ID) throws Exception;

    public List<Reservation> findAll() throws Exception;

    public ObservableList getAllStudentID();

    public String IdGenerator();

    public String setAvailableByID(String id);
}
