package com.example.BreweryFinder.dao;

public interface UserDao {

    boolean create(String username, String password);
    Integer findIdByUsername(String username);
}
