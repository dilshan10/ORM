package it.ijse.hibernet.bo.custom.impl;


import it.ijse.hibernet.bo.custom.ReservationBO;
import it.ijse.hibernet.dao.DAOFactory;
import it.ijse.hibernet.dao.DAOType;
import it.ijse.hibernet.dao.custom.impl.ReservationDAOImpl;
import it.ijse.hibernet.dto.ReservationDTO;
import it.ijse.hibernet.entty.Reservation;
import it.ijse.hibernet.entty.Room;
import javafx.collections.ObservableList;

import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    ReservationDAOImpl reservationDAO = DAOFactory.getInstance().getDAO(DAOType.RESERVATION);

    @Override
    public boolean add(ReservationDTO reservationDTO) throws Exception {
        return reservationDAO.add(new Reservation(
                reservationDTO.getRes_id(),
                reservationDTO.getDATE(),
                reservationDTO.getStudent_id(),
                reservationDTO.getRoom_type_id(),
                reservationDTO.getStatus()
        ));
    }

    @Override
    public boolean update(ReservationDTO reservationDTO) throws Exception {
        return reservationDAO.update(new Reservation(
                reservationDTO.getRes_id(),
                reservationDTO.getDATE(),
                reservationDTO.getStudent_id(),
                reservationDTO.getRoom_type_id(),
                reservationDTO.getStatus()
        ));
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return reservationDAO.delete(ID);
    }

    @Override
    public Reservation find(String ID) throws Exception {
        return reservationDAO.find(ID);
    }

    @Override
    public ObservableList<Reservation> findAll() throws Exception {
        return reservationDAO.findAll();
    }

    public ObservableList getAllStudentID(){
        return reservationDAO.getAllStudentID();
    }

    public String IdGenerator(){
        return reservationDAO.IdGenerator();
    }

    public String setAvailableByID(String id){
        return reservationDAO.setAvailableByID(id);
    }
}
