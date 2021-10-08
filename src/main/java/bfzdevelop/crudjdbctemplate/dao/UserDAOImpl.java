package bfzdevelop.crudjdbctemplate.dao;

import bfzdevelop.crudjdbctemplate.entity.User;
import bfzdevelop.crudjdbctemplate.entity.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDAOImpl implements IUserDAO {

    private final JdbcTemplate jdbcTemplate;

    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT id, username, email FROM users;";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    @Override
    public Optional<User> findById(int id) {
        String sql = "SELECT id, username, email FROM users WHERE id = ?;";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), id);
        return users.stream().findFirst();
    }

    @Override
    public int create(User user) {
        String sql = "INSERT INTO users (username, email) VALUES (?,?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getEmail());
    }

    @Override
    public int edit(User user) {
        String sql = "UPDATE users SET username = ?, email = ? WHERE id = ?;";
        return jdbcTemplate.update(sql, user.getUsername(), user.getEmail(), user.getId());
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?;";
        return jdbcTemplate.update(sql, id);
    }

}
