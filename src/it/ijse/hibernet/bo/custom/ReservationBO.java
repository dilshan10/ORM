package it.ijse.hibernet.bo.custom;

import it.ijse.hibernet.bo.SuperBO;
import it.ijse.hibernet.dto.ReservationDTO;
import it.ijse.hibernet.entty.Reservation;

import java.util.List;

public interface ReservationBO extends SuperBO {
    public boolean add(ReservationDTO reservationDTO) throws Exception;

    public boolean update(ReservationDTO reservationDTO) throws Exception;

    public boolean delete(String ID) throws Exception;

    public Reservation find (String ID) throws Exception;

    public List<Reservation> findAll() throws Exception;

    public List getAllID();

    public String IdGenerator();

    public Integer setAvailableByID(String id);
}
