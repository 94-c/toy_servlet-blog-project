package com.blog.dao;

import com.blog.entity.User;

import java.util.Date;

public class UserDAO extends JpaDAO<User>{

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
}
