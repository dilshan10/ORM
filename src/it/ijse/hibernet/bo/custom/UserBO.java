package it.ijse.hibernet.bo.custom;

import it.ijse.hibernet.bo.SuperBO;
import it.ijse.hibernet.dto.UserDTO;
import it.ijse.hibernet.entty.User;

import java.util.List;

public interface UserBO extends SuperBO {
    public boolean add(UserDTO userDTO) throws Exception;

    public boolean update(UserDTO userDTO) throws Exception;

    public boolean delete(String ID) throws Exception;

    public User find (String ID) throws Exception;

    public List<User> findAll() throws Exception;

    public List<User> findUserByName(String name);

    public String IdGenerator();
}
