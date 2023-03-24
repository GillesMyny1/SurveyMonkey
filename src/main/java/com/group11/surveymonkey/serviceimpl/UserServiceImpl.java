package com.group11.surveymonkey.serviceimpl;

import com.group11.surveymonkey.entity.User;
import com.group11.surveymonkey.service.UserService;
import com.group11.surveymonkey.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /*
    Post Operations
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /*
    Get Operations
     */
    @Override
    public List<User> fetchAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public Optional<User> fetchUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    /*
    Put Operations
     */
    @Override
    public User updateUserType(Integer userId, User.UserType newUserType) {
        User user = userRepository.findById(userId).get();
        user.setType(newUserType);
        return userRepository.save(user);
    }

    /*
    Delete Operations
     */
}
