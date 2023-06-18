package com.example.spring_rest.dao;

import com.example.spring_rest.entity.User;
import java.util.List;


public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUser(int id);

}