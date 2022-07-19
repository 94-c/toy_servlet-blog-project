package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.dto.LoginDTO;
import com.blog.dto.UserDTO;
import com.blog.entity.User;
import com.blog.log.Log;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
public class UserService {

    private final HttpServletRequest request;
    private final Log userLog = new Log();
    private final UserDAO userDAO = new UserDAO();

    private void userField(User user, UserDTO dto) {

        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());

    }

    public boolean join(UserDTO dto) {
        try {
            User user = new User();
            userField(user, dto);
            userDAO.create(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean login(LoginDTO dto) {
        User user = userDAO.login(dto.getEmail(), dto.getPassword());
        if (user == null) {
            return false;
        }
        return true;
    }


}
