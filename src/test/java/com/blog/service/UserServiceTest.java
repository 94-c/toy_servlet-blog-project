package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.dto.UserDTO;
import com.blog.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    private static final UserDAO userDAO = new UserDAO();

    @Test
    public void userIdCheck() {
        String email1 = "aaa@goggle.com";
        try {
            User result = userDAO.emailCheck(email1);

            assertNotNull(result.getEmail(), email1);
            System.out.println(result.getEmail());

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        String email = "hyeongwoo26@naver.com";
        String password = "123";
        try {
            UserDTO dto = new UserDTO();
            dto.setEmail(email);
            dto.setPassword(password);
            User result = userDAO.login(dto.getEmail(), dto.getPassword());
            assertNotNull(result.getEmail(), email);
            assertNotNull(result.getPassword(), password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void join() {
        User user = new User();
        try {
            UserDTO dto = new UserDTO();
            dto.setEmail("hhh@naver.com");
            dto.setPassword("1234");
            dto.setName("관리자");

            user.setEmail(dto.getEmail());
            user.setPassword(dto.getPassword());
            user.setName(dto.getName());

            User result = userDAO.create(user);

            assertEquals(user,result);

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByUserId() {
        Integer id = 28;
        try {
            UserDTO dto = new UserDTO();
            dto.setId(id);

            User result = userDAO.find(User.class, dto.getId());

            assertNotNull(result);
            System.out.println(result.getId() + " " + result.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUser() {
        Integer id = 28;
        User user = userDAO.find(User.class, id);
        if (user == null) {
            return;
        }
        try {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setEmail(user.getEmail());
            dto.setName("누굴까?");
            dto.setPassword("1234");

            user.setId(dto.getId());
            user.setEmail(dto.getEmail());
            user.setName(dto.getName());
            user.setPassword(dto.getPassword());

            User result = userDAO.update(user);

            assertEquals(user, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}