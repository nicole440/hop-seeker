package com.breweryfinder.dao;

import com.breweryfinder.models.User;

import java.time.LocalDate;
import java.util.List;

public interface UserDao {

    boolean create(String username, LocalDate dateOfBirth, String password);
    Integer findIdByUsername(String username);
    List findAll();
    User findByUsername(String lowercaseLogin);
}
