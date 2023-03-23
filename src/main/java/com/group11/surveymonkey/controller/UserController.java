package com.group11.surveymonkey.controller;

import com.group11.surveymonkey.service.UserService;
import com.group11.surveymonkey.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/user")
    public List<User> fetchAllUser() {
        return userService.fetchAllUser();
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUser(@PathVariable("userId") Integer userId) {
        return userService.fetchUserById(userId);
    }

    @PutMapping("/user/{userId}/{newUserType}")
    public User updateUserType(@PathVariable("userId") Integer userId, @PathVariable("newUserType") String newUserType) {
        User.UserType userType = null;
        newUserType = newUserType.trim();
        newUserType = newUserType.toLowerCase();
        if(newUserType == "admin") {
            userType = User.UserType.ADMIN;
        } else if(newUserType == "standard") {
            userType = User.UserType.STANDARD;
        }
        return userService.updateUserType(userId, userType);
    }
}
