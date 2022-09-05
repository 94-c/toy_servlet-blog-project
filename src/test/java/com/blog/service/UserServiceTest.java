package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.dto.user.CreateRequestUserDTO;
import com.blog.entity.User;
import com.blog.util.ExceptionUtil;
import com.blog.util.HibernateUtil;
import com.blog.util.Md5Util;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    private final UserService userService = new UserService();
    private final UserDAO userDAO = new UserDAO();

    @Test
    public void joinSuccess() {
        CreateRequestUserDTO newCreateDto = CreateRequestUserDTO.builder()
                .email("aaa@aaa.aaa")
                .password(Md5Util.md5("1234"))
                .build();

        User newUser = userService.join(newCreateDto);

        assertTrue(newUser != null && newUser.getId() > 0);
    }

    @Test
    public void joinFail() {
        CreateRequestUserDTO newCreateDto = CreateRequestUserDTO.builder()
                .email("")
                .password("")
                .name("테스트")
                .build();

        User newUser = userService.join(newCreateDto);
        if (newUser.getEmail() == null) {
            new NullPointerException("Error");
        }
        assertEquals(User.class, newUser.getClass());
    }

    @Test
    public void findByUserIdSuccess() {
        Integer id = 96;

        User findByUserId  = userService.findUserId(id);

        assertNotNull(findByUserId);
    }



    @Test(expected = ExceptionUtil.class)
    public void findByUserIdFail() {
        Integer id = 56;

        User findByUserId  = userService.findUserId(id);

        assertNotNull(findByUserId);
    }

    @Test
    public void findByEmailCheckSuccess() {
        CreateRequestUserDTO findByEmailDto = CreateRequestUserDTO.builder()
                .email("hyeongwoo26@naver.com")
                .build();

        List<User> findByEmail = userDAO.findWithNamedQuery("User_Email_Check", "email", findByEmailDto.getEmail());

        assertTrue(findByEmail.size() > 0);
    }

    @Test
    public void findByEmailCheckFail() {
        CreateRequestUserDTO findByEmailDto = CreateRequestUserDTO.builder()
                .email("hyeongwoo26@naver.com")
                .build();

        List<User> findByEmail = userDAO.findWithNamedQuery("User_Email_Check", "email", findByEmailDto.getEmail());

        assertTrue(findByEmail.size() > 1);
    }



}