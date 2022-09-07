package com.blog.service;

import com.blog.dao.EmailTokensDAO;
import com.blog.dao.UserDAO;
import com.blog.dao.UserLogDAO;
import com.blog.dto.LoginRequestDTO;
import com.blog.dto.user.CreateRequestUserDTO;
import com.blog.dto.user.EditRequestUserDTO;
import com.blog.entity.EmailTokens;
import com.blog.entity.User;
import com.blog.service.exception.UserServiceException;
import com.blog.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;

import java.util.logging.Level;

@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO = new UserDAO();


    public boolean userEmailCheck(String email) {
         return userDAO.emailCheck(email);
    }

    public User join(CreateRequestUserDTO dto) throws UserServiceException{
        User newUser = dto.ToEntity();
        User result = userDAO.create(newUser);
        if (result == null) {
            throw new UserServiceException("create User Error", Level.WARNING);
        }
        return newUser;
    }

    public User login(LoginRequestDTO dto) {
        return userDAO.login(dto.getEmail(), dto.getPassword());
    }


    public User updateEmailStateAuth(Integer id) throws UserServiceException {
        User findByUserId = userDAO.find(id);
        if (findByUserId == null) {
            throw new UserServiceException("findByUserId", Level.WARNING);
        }
        //TODO 이메일 인가에 대한 state dto를 태워야 함.
        User updateAuthState = userDAO.updateState(findByUserId);
        return updateAuthState;
    }

    public User findUserId(Integer id) throws UserServiceException{
        User findByUserId = userDAO.find(id);
        if (findByUserId == null) {
            throw new UserServiceException("findUserId Error", Level.WARNING);
        }
        return findByUserId;
    }

    public User updateUser(EditRequestUserDTO dto) throws UserServiceException {
        User user = userDAO.find(User.class, dto.getId());
        if (user == null) {
            throw new UserServiceException("findUserId Error", Level.WARNING);
        }
        User updateUserDto = dto.ToEntity(user);
        User updateUser = userDAO.update(updateUserDto);
        if (updateUser == null) {
            throw new UserServiceException("updateUser Error", Level.WARNING);
        }
        return user;
    }

}
