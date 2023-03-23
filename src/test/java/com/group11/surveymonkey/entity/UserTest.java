package com.group11.surveymonkey.entity;

import org.hibernate.usertype.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User("tester", "tester", User.UserType.ADMIN);
    }

    @Test
    void getId() {
        Assertions.assertNull(user.getId());
    }

    @Test
    void setId() {
        user.setId(3);
        Assertions.assertEquals(3, user.getId());
    }

    @Test
    void getUsername() {
        Assertions.assertEquals("tester", user.getUsername());
    }

    @Test
    void setUsername() {
        user.setUsername("test");
        Assertions.assertEquals("test", user.getUsername());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("tester", user.getPassword());
    }

    @Test
    void setPassword() {
        user.setPassword("test");
        Assertions.assertEquals("test", user.getPassword());
    }

    @Test
    void getType() {
        Assertions.assertEquals(User.UserType.ADMIN, user.getType());
    }

    @Test
    void setType() {
        user.setType(User.UserType.STANDARD);
        Assertions.assertEquals(User.UserType.STANDARD, user.getType());
    }
}