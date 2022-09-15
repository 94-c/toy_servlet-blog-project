package com.blog.service;

import com.blog.data.dao.UserDAO;
import com.blog.dto.user.CreateRequestUserDTO;
import com.blog.data.entity.User;
import com.blog.service.exception.PostServiceException;
import com.blog.util.Md5Util;
import org.junit.Test;

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


    @Test(expected = PostServiceException.class)
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

        boolean findByEmail = userService.userEmailCheck(findByEmailDto.getEmail());

        assertTrue(findByEmail);
    }






}