package com.blog.dao;

import com.blog.entity.User;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

public class UserDAO extends JpaDAO<User>{

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

    public List<User> findAllCreateQuery() {
        return super.findAllCreateQuery("User_Login_Check");
    }
}
