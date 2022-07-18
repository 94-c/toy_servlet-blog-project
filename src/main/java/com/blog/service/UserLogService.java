package com.blog.service;

import com.blog.dao.UserLogDAO;
import com.blog.dto.UserLogDTO;
import com.blog.entity.User;
import com.blog.entity.UserLog;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RequiredArgsConstructor
public class UserLogService {

    private final HttpServletRequest request;
    private final UserLogDAO userLogDAO = new UserLogDAO();

    private void userLogField(UserLog userLog, UserLogDTO dto){
        User user = new User();
        user.setId(dto.getUserId());

        userLog.setId(dto.getId());
        userLog.setUserIp(dto.getUserIp());
        userLog.setUserAgent(dto.getUserAgent());

    }

    private String userIp() {

        String ip = null;
        InetAddress address;

        try{
            address = Inet4Address.getLocalHost();
            ip = address.getHostAddress();
        }catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    public UserLog createUserLog(UserLogDTO dto) {
        UserLog userLog = new UserLog();
        userLogField(userLog, dto);
        return userLogDAO.create(userLog);
    }

}
