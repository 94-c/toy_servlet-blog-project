package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.dto.EmailTokensDTO;
import com.blog.dto.LoginDTO;
import com.blog.dto.UserDTO;
import com.blog.entity.User;
import com.blog.log.Log;

import javax.servlet.http.HttpServletRequest;


public class UserService {

    private final HttpServletRequest request;
    private final Log userLog = new Log();
    private static final UserDAO userDAO = new UserDAO();
    private final EmailService emailService = new EmailService();
    private final EmailTokensService emailTokensService = new EmailTokensService();

    public UserService(HttpServletRequest request) {
        this.request = request;
    }

    private void userField(User user, UserDTO dto) {

        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setState(dto.getState());

    }

    public User join(UserDTO dto) {
        User user = new User();
        try {
            userField(user, dto);
            User result = userDAO.create(user);
            if (result != null) {
                String authKey = emailService.sendEmail(dto.getEmail());
                EmailTokensDTO emailTokensDTO = new EmailTokensDTO();
                emailTokensDTO.setToken(authKey);
                emailTokensDTO.setUserId(dto.getId());
                emailTokensService.updateTokens(emailTokensDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean login(LoginDTO dto) {
        User user = userDAO.login(dto.getEmail(), dto.getPassword());
        if (user == null) {
            return false;
        }
        return true;
    }

    public static User emailCheck(String email) {
        User result = userDAO.emailCheck(email);
        return result;
    }




}
