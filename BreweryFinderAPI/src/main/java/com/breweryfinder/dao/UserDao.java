package com.breweryfinder.dao;

public interface UserDao {

    boolean create(String username, String password);
    Integer findIdByUsername(String username);
}
