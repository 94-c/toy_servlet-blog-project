package com.blog.service;

import com.blog.dto.UserDTO;
import com.blog.entity.User;
import com.blog.util.ExceptionUtil;
import org.junit.Test;

import javax.persistence.Id;

import static org.junit.Assert.*;

public class PosServiceHardTest {

    private final PostService postService = new PostService();
    private final UserService userService = new UserService();

    @Test
    public void findByUserId() {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(99);

        userService.findUserId(userDTO.getId());

        ExceptionUtil exceptionUtil = assertThrows(ExceptionUtil.class, () -> userService.findUserId(userDTO.getId()));

    }


}
