package com.example.BreweryFinder.dao;

import com.example.BreweryFinder.models.User;

public interface UserDao {

    boolean create(String username, String password);
    Integer findIdByUsername(String username);
}
