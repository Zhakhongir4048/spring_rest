package com.example.spring_rest.controller;

import com.example.spring_rest.entity.User;
import com.example.spring_rest.exception_handling.NoSuchUserException;
import com.example.spring_rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private final UserService userService;

    @Autowired
    public MyRESTController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{userid}")
    public User getUser(@PathVariable("userid") int id) {
        User user = userService.getUser(id);
        if (Objects.isNull(user)) {
            throw new NoSuchUserException("There is no employee with ID = " + id + " in Database");
        }
        return user;
    }

    // Аннотация @RequestBody связывает тело HTTP метода с параметром метода Controller-а
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        userService.saveUser(user);
        return getUser(user.getId());
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/users/{userid}")
    public String deleteUser(@PathVariable("userid") int id) {
        User user = userService.getUser(id);
        if (Objects.nonNull(user)) {
            userService.deleteUser(id);
            return "User with ID = " + id + " was deleted";
        }
        throw new NoSuchUserException("There is no employee with ID = " + id + " in Database");
    }

}