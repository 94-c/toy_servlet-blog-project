package com.blog.service;

import com.blog.dto.LogDTO;
import com.blog.dto.LoginDTO;
import com.blog.dto.UserDTO;
import com.blog.entity.User;
import com.blog.util.Md5Util;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserService();

    @Test
    public void joinSuccess() {
       UserDTO dto = new UserDTO();
       dto.setEmail("hyeongwoo26@gmail.com");
       dto.setPassword(Md5Util.md5("1234"));
       dto.setState(0);

       User user = userService.join(dto);

       assertNotEquals(dto, user);
       assertEquals(User.class, user.getClass());

    }

    @Test
    public void joinFailEmailCheck() {
        String email = "hyeongwoo26@gmail.com";

        boolean emailCheck = userService.userEmailCheck(email);

        if (emailCheck) {
            UserDTO dto = new UserDTO();
            dto.setEmail(email);
            dto.setPassword(Md5Util.md5("1234"));
            dto.setState(0);
        }
        System.out.println("중복된 이메일");

        assertNotEquals(emailCheck, email);
    }

    @Test
    public void loginSuccess() {

        LoginDTO dto = new LoginDTO();
        dto.setEmail("hyeongwoo26@naver.com");
        dto.setPassword(Md5Util.md5("1234"));

        User result = userService.login(dto);

        assertNotEquals(result, dto);
    }

    @Test(expected = Exception.class)
    public void loginFail() {

        LoginDTO dto = new LoginDTO();
        dto.setEmail("hyeongwoo26@naver.com");
        dto.setPassword(Md5Util.md5("33333"));

        User result = userService.login(dto);

        if (result == null) {
            System.out.println("로그인 실패");
        }
        assertNotEquals(result, dto);
    }

    @Test
    public void findUserIdSuccess() {
        Integer id = 1;

        User result = userService.findUserId(id);

        assertEquals(id, result.getId());
    }

    @Test(expected = Exception.class)
    public void findUserIdFail() {
        Integer id = 99;

        User result = userService.findUserId(id);

        assertEquals(id, result.getId());
    }

    @Test
    public void updateUserSuccess() throws Exception {
        Integer id = 1;

        User findById = userService.findUserId(id);

        if (findById == null) {
            System.out.println("아이디 조회 실패");
        }
        UserDTO dto = new UserDTO();
        dto.setId(findById.getId());
        dto.setName("관리자");
        dto.setEmail("hyeongwoo26@naver.com");
        dto.setPassword(Md5Util.md5("1234"));

        User result = userService.updateUser(dto);

        assertNotEquals(result, dto);
    }

    @Test(expected = Exception.class)
    public void updateUserFail() throws Exception {
        Integer id = 99;

        User findById = userService.findUserId(id);

        if (findById == null) {
            System.out.println("아이디 조회 실패");
        }
        UserDTO dto = new UserDTO();
        dto.setId(findById.getId());
        dto.setName("관리자");
        dto.setEmail("hyeongwoo26@naver.com");
        dto.setPassword(Md5Util.md5("1234"));

        User result = userService.updateUser(dto);

        assertNotEquals(result, dto);
    }

}