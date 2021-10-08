package bfzdevelop.crudjdbctemplate.dao;

import bfzdevelop.crudjdbctemplate.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {

    public List<User> findAll();
    public Optional<User> findById(int id);
    public int create(User user);
    public int edit(User user);
    public int delete(int id);

}
