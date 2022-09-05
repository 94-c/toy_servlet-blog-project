package com.blog.service;

import com.blog.dao.UserDAO;
import com.blog.dao.UserLogDAO;
import com.blog.dto.LoginRequestDTO;
import com.blog.dto.user.CreateRequestUserDTO;
import com.blog.dto.user.EditRequestUserDTO;
import com.blog.entity.User;
import com.blog.service.exception.UserServiceException;
import com.blog.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;

import java.util.logging.Level;

@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO = new UserDAO();
    private final UserLogDAO userLogDAO = new UserLogDAO();

    public boolean userEmailCheck(String email) {
         return userDAO.emailCheck(email);
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


    public User updateEmailStateAuth(Integer id) {
        User findByUserId = userDAO.find(id);
        if (findByUserId == null) {
            throw new UserServiceException("findByUserId", Level.WARNING);
        }
        //TODO 이메일 인가에 대한 state dto를 태워야 함.
        User updateAuthState = userDAO.updateState(findByUserId);
        return updateAuthState;
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
        User updateUserDto = dto.ToEntity(user);
        User updateUser = userDAO.update(updateUserDto);
        if (updateUser == null) {
            throw new ExceptionUtil("updateUser Error");
        }
        return user;
    }

}
