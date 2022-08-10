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

    private static UserService userService = new UserService();
    private static EmailService emailService = new EmailService();
    private static EmailTokensService emailTokensService = new EmailTokensService();

    @Test
    public void findByEmail() {
        User user = new User();
        user.setId(96);
        try {
            User result = userService.findUserId(user.getId());
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
            assertNotNull(e);
        }
    }

    @Test
    public void login() {
        LoginDTO dto = new LoginDTO();
        dto.setEmail("hyeongwoo26@naver.com");
        dto.setPassword(Md5Util.md5("1234"));

        User login = userService.login(dto);
    }

    @Test
    public void updateStateByEmailToken() {
        User user = new User();
        user.setId(100);
        User userId = userService.findUserId(user.getId());
        if (userId == null) {
            assertNotNull("Not Find UserId");
        }
        EmailTokens emailTokens = new EmailTokens();
        emailTokens.setId(77);
        emailTokens.setUserId(user.getId());
        emailTokens.setToken("427437");
        try {
            EmailTokensDTO dto = new EmailTokensDTO();
            dto.setId(emailTokens.getId());
            dto.setUserId(emailTokens.getUserId());
            dto.setToken(emailTokens.getToken());
            dto.setState(1);

            EmailTokens token = emailTokensService.findByToken(dto.getToken());
            boolean tokens = emailTokensService.updateState(dto);

            if (tokens) {
                userService.updateState(user.getId());
            }
            assertEquals(emailTokens.getId(), dto.getId());
            assertEquals(emailTokens.getToken(), token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createUser() {
        User user = new User();
        String password = Md5Util.md5("123");
        user.setEmail("hhh@naver.com");
        user.setPassword(password);
        user.setName("테스트");
        try {
            UserDTO dto = new UserDTO();
            dto.setEmail(user.getEmail());
            dto.setPassword(user.getPassword());
            dto.setName(user.getName());

            User result = userService.join(dto);
            assertEquals(user.getEmail(), result.getEmail());
            assertEquals(user.getPassword(), password);
            assertEquals(user.getName(), result.getName());

            if (result != null) {
                emailService.sendEmail(result.getId(), result.getEmail());
            }
        } catch (Exception e) {
            e.printStackTrace();
            assertNotNull(e);
        }
    }

    @Test
    public void updateUser() {
        String password = Md5Util.md5("123");

        User user = new User();
        user.setId(100);
        user.setEmail("hhhh@naver.com");
        user.setPassword(password);
        user.setName("테스트");
        try {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setPassword(user.getPassword());
            dto.setName(user.getName());

            User result = userService.updateUser(dto);
            assertEquals(user.getId(), result.getId());
            assertEquals(user.getEmail(), result.getEmail());
            assertEquals(user.getPassword(), password);
            assertEquals(user.getName(), result.getName());

        } catch (Exception e) {
            e.printStackTrace();
            assertNotNull(e);
        }
    }

}