package com.blog.service;

import com.blog.dao.UserLogDAO;
import com.blog.dto.UserLogDTO;
import com.blog.entity.User;
import com.blog.entity.UserLog;
import com.blog.log.Log;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UserLogService {

    private final UserLogDAO userLogDAO = new UserLogDAO();

    private final Log log = new Log();

    private void userLogField(UserLog userLog, UserLogDTO dto){
        User user = new User();
        user.setId(dto.getUserId());

        userLog.setId(dto.getId());
        userLog.setUserAgent(dto.getUserAgent());

    }

    public UserLog createUserLog(UserLogDTO dto) {
        UserLog userLog = new UserLog();
        userLog.setUserId(dto.getUserId());
        userLogField(userLog, dto);
        return userLogDAO.create(userLog);
    }

}
