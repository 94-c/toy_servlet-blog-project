package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.dto.LoginDTO;
import com.blog.dto.UserDTO;
import com.blog.entity.User;
import com.blog.log.Log;
import com.blog.util.Md5Util;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class UserService {

    protected final HttpServletRequest request;
    protected final UserDAO userDAO = new UserDAO();

    public UserService(HttpServletRequest request) {
        this.request = request;
    }

    private void userField(User user, UserDTO dto) {
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(Md5Util.md5(dto.getPassword()));
        user.setName(dto.getName());
        user.setState(dto.getState());
    }

    public boolean userEmailCheck(String email) {
        try {
            userDAO.emailCheck(email);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public User join(UserDTO dto) {
        User user = new User();
        try {
            userField(user, dto);
            userDAO.create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public User login(LoginDTO dto) throws Exception {
        User user = userDAO.login(dto.getEmail(), dto.getPassword());
        if (user == null) {
            throw new Exception();
        }
        return user;
    }


    public User updateState(Integer id) {
        User user = userDAO.find(User.class, id);
        userDAO.updateState(user);
        return user;
    }

    public boolean findUserId(Integer id) {
        User user = userDAO.find(User.class, id);
        if (user == null) {
            return false;
        }
        request.setAttribute("user", user);

        return true;
    }

    public boolean updateUser(UserDTO dto) {
        User user = userDAO.find(User.class, dto.getId());
        if (user == null) {
            return false;
        }
        try {
            userField(user, dto);
            userDAO.update(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
