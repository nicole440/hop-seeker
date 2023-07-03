package com.breweryfinder.dao;

import com.breweryfinder.models.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(String username, LocalDate dateOfBirth, String password) {
        String sql = "INSERT INTO users (username, date_of_birth, password_hash) " +
                "VALUES (?, ?, ?) RETURNING user_id";
        String password_hash = new BCryptPasswordEncoder().encode(password);
        Integer newUserId;
        newUserId = jdbcTemplate.queryForObject(sql, Integer.class, username, dateOfBirth, password_hash);

        if (newUserId == null) return false;
        else return true;
    }

    // SQL query tested in pgAdmin - Success
    @Override
    public Integer findIdByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");
        Integer userId;
                try {
                    userId = jdbcTemplate.queryForObject("SELECT user_id FROM users WHERE username = ?", Integer.class, username);
                } catch (NullPointerException | EmptyResultDataAccessException e) {
                    throw new UsernameNotFoundException("User " + username + " was not found.");
                }
        return userId;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            User user = mapRowToUser(results);
            users.add(user);
        }
        return users;
    }

    @Override
    public User findByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");

        for (User user : this.findAll()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        throw new UsernameNotFoundException("User " + username + " was not found.");
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        user.setPassword(rs.getString("password_hash"));
        user.setActivated(true);
        user.setAuthorities("USER");
        return user;
    }
}
