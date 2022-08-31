package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.dto.LoginRequestDTO;
import com.blog.dto.user.CreateRequestUserDTO;
import com.blog.dto.user.EditRequestUserDTO;
import com.blog.entity.User;
import com.blog.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    protected final UserDAO userDAO = new UserDAO();

    public boolean userEmailCheck(String email) {
        User result = userDAO.emailCheck(email);
        if (result == null) {
            throw new ExceptionUtil("userEmailCheck Error");
        }
        return true;
    }

    public User join(CreateRequestUserDTO dto) {
        User newUser = dto.ToEntity();
        User result = userDAO.create(newUser);
        if (result == null) {
            throw new ExceptionUtil("create User Error");
        }
        return newUser;
    }

    public User login(LoginRequestDTO dto) {
        return userDAO.login(dto.getEmail(), dto.getPassword());
    }


    public User updateState(Integer id) {
        User user = userDAO.find(User.class, id);
        userDAO.updateState(user);
        return user;
    }

    public User findUserId(Integer id) {
        User findByUserId = userDAO.find(id);
        if (findByUserId == null) {
            throw new ExceptionUtil("findUserId Error");
        }
        return findByUserId;
    }

    public User updateUser(EditRequestUserDTO dto) throws Exception {
        User user = userDAO.find(User.class, dto.getId());
        if (user == null) {
            throw new Exception();
        }
        User updateUser = userDAO.update(user);
        if (updateUser == null) {
            throw new ExceptionUtil("updateUser Error");
        }
        return user;
    }


}
