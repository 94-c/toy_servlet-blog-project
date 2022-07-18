package com.blog.dao;

import com.blog.entity.UserLog;

public class UserLogDAO extends JpaDAO<UserLog> {

    @Override
    public UserLog create(UserLog entity) {
        return super.create(entity);
    }
}
