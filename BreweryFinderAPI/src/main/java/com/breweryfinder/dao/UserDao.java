package com.breweryfinder.dao;

import com.breweryfinder.models.User;

public interface UserDao {

    boolean create(String username, String password);
    Integer findIdByUsername(String username);
    User findByUsername(String lowercaseLogin);
}
