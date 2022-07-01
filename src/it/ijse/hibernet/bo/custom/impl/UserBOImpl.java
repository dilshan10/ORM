package it.ijse.hibernet.bo.custom.impl;


import it.ijse.hibernet.bo.custom.UserBO;
import it.ijse.hibernet.dao.DAOFactory;
import it.ijse.hibernet.dao.DAOType;
import it.ijse.hibernet.dao.custom.impl.UserDAOImpl;
import it.ijse.hibernet.dto.UserDTO;
import it.ijse.hibernet.entty.User;

import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAOImpl userDAO = DAOFactory.getInstance().getDAO(DAOType.USER);

    @Override
    public boolean add(UserDTO userDTO) throws Exception {
        return userDAO.add(new User(
                userDTO.getUser_ID(),
                userDTO.getUser_Name(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean update(UserDTO userDTO) throws Exception {
        return userDAO.update(new User(
                userDTO.getUser_ID(),
                userDTO.getUser_Name(),
                userDTO.getPassword()
        ));
    }

    @Override
    public boolean delete(String ID) throws Exception {
        return userDAO.delete(ID);
    }

    @Override
    public User find(String ID) throws Exception {
        return userDAO.find(ID);
    }

    @Override
    public List<User> findAll() throws Exception {
        return userDAO.findAll();
    }
}
