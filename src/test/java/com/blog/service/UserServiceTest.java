package com.blog.service;

import com.blog.dto.EmailTokensDTO;
import com.blog.dto.LoginDTO;
import com.blog.dto.UserDTO;
import com.blog.entity.EmailTokens;
import com.blog.entity.User;
import com.blog.util.Md5Util;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserService();

    @Test
    public void joinSuccess() {
       UserDTO dto = new UserDTO();
    }


}