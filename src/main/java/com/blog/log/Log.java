package com.blog.log;

import com.blog.dto.LogDTO;

public class Log implements LogDTO{

    public String login(LogDTO dto) {
        return dto.login;
    }

    public String logOut(LogDTO dto) {
        return dto.logOut;
    }

    public String createPost(LogDTO dto) {
        return dto.postCreate;
    }

    public String editPost(LogDTO dto) {
        return dto.postUpdate;
    }

    public String deletePost(LogDTO dto) {
        return dto.postDelete;
    }



}
