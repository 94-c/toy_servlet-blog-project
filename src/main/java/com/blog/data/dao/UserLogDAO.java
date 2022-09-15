package com.blog.data.dao;

import com.blog.data.entity.UserLog;

import java.util.Date;

public class UserLogDAO extends JpaDAO<UserLog> {

    @Override
    public UserLog create(UserLog userLog) {
        userLog.setCreatedAt(new Date());
        return super.create(userLog);
    }
}
