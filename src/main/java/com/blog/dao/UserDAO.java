package com.blog.dao;

import com.blog.entity.User;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO extends JpaDAO<User> {

    private EntityManager entityManager;

    @Override
    public User create(User entity) {
        entity.setCreatedAt(new Date());
        return super.create(entity);
    }

    @Override
    public User update(User entity) {
        entity.setUpdatedAt(new Date());
        return super.update(entity);
    }

    public User login(String email, String password) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("email", email);
        parameters.put("password", password);

        List<User> userList = super.findWithNamedQuery("User_Login_Check", parameters);

        return userList.size() == 1 ? userList.get(0) : null;
    }
}
