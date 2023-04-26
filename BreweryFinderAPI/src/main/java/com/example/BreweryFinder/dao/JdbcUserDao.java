package com.example.BreweryFinder.dao;

import com.example.BreweryFinder.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(String username, String password) {
        return false;
    }

    // SQL query tested in pgAdmin - Success
    @Override
    public Integer findIdByUsername(String username) {
        Integer userId = jdbcTemplate.queryForObject("SELECT user_id FROM users WHERE username = ?", Integer.class, username);
        return userId;
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setActivated(true);
        user.setAuthorities("USER");
        return user;
    }
}
