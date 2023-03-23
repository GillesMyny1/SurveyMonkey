package com.group11.surveymonkey.service;

import com.group11.surveymonkey.entity.User;
import java.util.*;


public interface UserService {
    User saveUser(User user);

    List<User> fetchAllUser();

    Optional<User> fetchUserById(Integer userId);

    User updateUserType(Integer surveyId, User.UserType newUserType);
}
