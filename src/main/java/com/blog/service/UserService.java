package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.dto.LoginDTO;
import com.blog.dto.UserDTO;
import com.blog.entity.User;
import com.blog.util.Md5Util;

public class UserService {

    protected final UserDAO userDAO = new UserDAO();

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
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public User join(UserDTO dto) {
        User user = new User();
        userField(user, dto);
        userDAO.create(user);
        return user;
    }

    public User login(LoginDTO dto) {
        return userDAO.login(dto.getEmail(), dto.getPassword());
    }


    public User updateState(Integer id) {
        User user = userDAO.find(User.class, id);
        userDAO.updateState(user);
        return user;
    }

    public User findUserId(Integer id) {
        User user = userDAO.find(User.class, id);
        if (user == null) {
            return null;
        }
        return user;
    }

    public User updateUser(UserDTO dto) throws Exception {
        User user = userDAO.find(User.class, dto.getId());
        if (user == null) {
            throw new Exception();
        }
        try {
            userField(user, dto);
            userDAO.update(user);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }


}
