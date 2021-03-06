package it.ijse.hibernet.dao;

import it.ijse.hibernet.dao.custom.impl.ReservationDAOImpl;
import it.ijse.hibernet.dao.custom.impl.RoomDAOImpl;
import it.ijse.hibernet.dao.custom.impl.StudentDAOImpl;
import it.ijse.hibernet.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return (null == daoFactory) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO>T getDAO(DAOType daoType){
        switch (daoType){
            case STUDENT:
                return (T) new StudentDAOImpl();
            case ROOM:
                return (T) new RoomDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            case RESERVATION:
                return (T) new ReservationDAOImpl();
            default:
                return null;
        }
    }
}
