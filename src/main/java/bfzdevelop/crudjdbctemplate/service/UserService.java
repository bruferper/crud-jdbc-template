package bfzdevelop.crudjdbctemplate.service;

import bfzdevelop.crudjdbctemplate.dao.IUserDAO;
import bfzdevelop.crudjdbctemplate.entity.User;
import bfzdevelop.crudjdbctemplate.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IUserDAO userDAO;

    public UserService(IUserDAO userDAO){
        this.userDAO = userDAO;
    }

    public List<User> findAll(){
        return userDAO.findAll();
    }

    public User findById(int id){
        return userDAO.findById(id).orElseThrow(() -> new NotFoundException("User not exists."));
    }

    public void create(User user){
        userDAO.create(user);
    }

    public void edit(int id, User user){
        findById(id);
        user.setId(id);
        userDAO.edit(user);
    }

    public void delete(int id){
        findById(id);
        userDAO.delete(id);
    }

}
