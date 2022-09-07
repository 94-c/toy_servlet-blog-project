package com.blog.dao;

import com.blog.entity.User;
import com.blog.util.Md5Util;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserDAOTest {

    private final UserDAO userDAO = new UserDAO();

    @Test
    public void createUser_success() {

        User user = new User();
        user.setEmail("aaa@aaa.aaa");
        user.setPassword(Md5Util.md5("1234"));
        user.setName("테스트");

        User newUser = userDAO.create(user);

        assertEquals(user, newUser);
        assertTrue(newUser != null && newUser.getId() > 0);
    }

    @Test
    public void updateUser_success() {

        User user = new User();
        user.setId(164);
        user.setEmail("aaa@aaa.aaa");
        user.setPassword(Md5Util.md5("1234"));
        user.setName("테스트 수정");

        User editUser = userDAO.update(user);

        assertEquals(user.getId(), editUser.getId());
    }

    @Test
    public void emailCheck_success() {

        String email = "hyeongwoo26@naver.com";

        boolean emailCheck = userDAO.emailCheck(email);

        assertTrue(emailCheck);
    }

    @Test
    public void emailCheck_fail() {

        String email = "hyeongwoo26@naver.commmmmm";

        boolean emailCheck = userDAO.emailCheck(email);

        assertTrue(emailCheck);
    }

}