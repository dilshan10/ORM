package it.ijse.hibernet.bo.custom.impl;


import it.ijse.hibernet.bo.custom.RoomBO;
import it.ijse.hibernet.dao.DAOFactory;
import it.ijse.hibernet.dao.DAOType;
import it.ijse.hibernet.dao.custom.impl.RoomDAOImpl;
import it.ijse.hibernet.dto.RoomDTO;
import it.ijse.hibernet.entty.Room;
import javafx.collections.ObservableList;

import java.util.List;

public class RoomBOImpl implements RoomBO {

    RoomDAOImpl roomDAO = DAOFactory.getInstance().getDAO(DAOType.ROOM);

    @Override
    public boolean add(RoomDTO roomDTO) throws Exception {
        return roomDAO.add(new Room(
                roomDTO.getRoom_type_ID(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQTY()
        ));
    }

    @Override
    public boolean update(RoomDTO roomDTO) throws Exception {
        return roomDAO.update(new Room(
                roomDTO.getRoom_type_ID(),
                roomDTO.getType(),
                roomDTO.getKeyMoney(),
                roomDTO.getQTY()
        ));
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return roomDAO.delete(ID);
    }

    @Override
    public Room find(String ID) throws Exception {
        return roomDAO.find(ID);
    }

    @Override
    public List<Room> findAll() throws Exception {
        return roomDAO.findAll();
    }

    @Override
    public ObservableList<Room> getID() throws Exception {
        return roomDAO.getID();
    }
}
