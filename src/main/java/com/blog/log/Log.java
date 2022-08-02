package com.blog.log;

import com.blog.dto.LogDTO;

public class Log implements LogDTO{

    public String userLogin(LogDTO dto) {
        return dto.login;
    }

}
