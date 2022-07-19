package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.dto.UserDTO;
import com.blog.entity.User;
import com.blog.log.UserLog;
import com.sun.deploy.net.HttpRequest;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
public class UserService {

    private final HttpServletRequest request;
    private final UserLog userLog = new UserLog();
    private final UserDAO userDAO = new UserDAO();

    private void userField(User user, UserDTO dto) {

        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());

    }

    public boolean join(UserDTO dto) {
        try{
            User user = new User();
            userField(user, dto);
            userDAO.create(user);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
