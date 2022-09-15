package com.blog.service;

import com.blog.data.dao.UserDAO;
import com.blog.data.dto.UserDto;
import com.blog.data.entity.User;
import com.blog.service.exception.UserServiceException;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Level;


@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO = new UserDAO();

    public boolean userEmailCheck(String email) {
         return userDAO.emailCheck(email);
    }

    public User join(UserDto dto) throws UserServiceException{
        User newUser = dto.toCreateEntity();
        User result = userDAO.create(newUser);
        if (result == null) {
            throw new UserServiceException("create User Error", Level.ERROR);
        }
        return newUser;
    }

    public User login(UserDto dto) throws UserServiceException{
        User result = userDAO.login(dto.toLoginEntity().getEmail(), dto.toLoginEntity().getPassword());
        if (result == null) {
            throw new UserServiceException("login Error", Level.ERROR);
        }
        return result;
    }


    public User updateEmailStateAuth(Integer id) throws UserServiceException {
        User findByUserId = userDAO.find(id);
        if (findByUserId == null) {
            throw new UserServiceException("findByUserId", Level.ERROR);
        }
        return userDAO.updateState(findByUserId);
    }

    public User findUserId(Integer id) throws UserServiceException{
        User findByUserId = userDAO.find(id);
        if (findByUserId == null) {
            throw new UserServiceException("findUserId Error", Level.ERROR);
        }
        return findByUserId;
    }

    public User updateUser(UserDto dto) throws UserServiceException {
        User user = userDAO.find(User.class, dto.getId());
        if (user == null) {
            throw new UserServiceException("findUserId Error", Level.ERROR);
        }
        User updateUserDto = dto.toEditEntity(user);
        User updateUser = userDAO.update(updateUserDto);
        if (updateUser == null) {
            throw new UserServiceException("updateUser Error", Level.ERROR);
        }
        return user;
    }

}
