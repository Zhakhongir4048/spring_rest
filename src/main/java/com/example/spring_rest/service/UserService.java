package com.example.spring_rest.service;

import com.example.spring_rest.entity.User;
import java.util.List;


public interface UserService {

  List<User> getAllUsers();

  void saveUser(User user);

  User getUser(int id);

  void deleteUser(int id);

}