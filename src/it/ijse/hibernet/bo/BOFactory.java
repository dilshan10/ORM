package it.ijse.hibernet.bo;

import it.ijse.hibernet.bo.custom.impl.ReservationBOImpl;
import it.ijse.hibernet.bo.custom.impl.RoomBOImpl;
import it.ijse.hibernet.bo.custom.impl.StudentBOImpl;
import it.ijse.hibernet.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getInstance(){
        return (null == boFactory) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO> T getBO(BOType boType){
        switch (boType){
            case STUDENT:
                return (T) new StudentBOImpl();
            case RESERVATION:
                return (T) new ReservationBOImpl();
            case USER:
                return (T) new UserBOImpl();
            case ROOM:
                return (T) new RoomBOImpl();
            default:
                return null;
        }
    }

}
