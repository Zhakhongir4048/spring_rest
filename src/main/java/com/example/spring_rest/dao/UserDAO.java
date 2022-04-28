package com.example.spring_rest.dao;

import com.example.spring_rest.entity.User;

import java.util.List;


public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

}