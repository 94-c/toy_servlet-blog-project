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
    private static final UserDAO userDAO = new UserDAO();
    private void userField(User user, UserDTO dto) {

        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setState(dto.getState());

    }

    public boolean userIdCheck(String email) {
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

    public User login(LoginDTO dto) {
        User user = userDAO.login(dto.getEmail(), dto.getPassword());
        if (user == null) {
            System.out.println("로그인 실패");
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


}
