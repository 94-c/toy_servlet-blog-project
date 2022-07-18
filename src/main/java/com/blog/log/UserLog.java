package com.blog.log;

import com.blog.entity.User;

public class UserLog {

    public void userLogin(User user){
        System.out.println(user.toString());
    }

    public void userLogOut(){
        System.out.println("로그아웃");
    }

}
