package com.blog.service;

import com.blog.dao.EmailTokensDAO;
import com.blog.dto.EmailTokensDTO;
import com.blog.entity.EmailTokens;

import javax.servlet.http.HttpServletRequest;


public class EmailTokensService {

    private static final HttpServletRequest request = null;
    private final EmailTokensDAO emailTokensDAO = new EmailTokensDAO();



    private void emailTokenField(EmailTokens emailTokens, EmailTokensDTO dto) {

        emailTokens.setId(dto.getId());
        emailTokens.setToken(dto.getToken());
        emailTokens.setState(dto.getState());
        emailTokens.setAuthAt(dto.getAuthAt());
        emailTokens.setSendedAt(dto.getSendedAt());
        emailTokens.setDeletedAt(dto.getDeleteAt());
        emailTokens.setUserId(dto.getUserId());

    }

    public boolean updateTokens(EmailTokensDTO dto) {
        try {
            EmailTokens emailTokens = new EmailTokens();
            emailTokens.setUserId(dto.getUserId());
            emailTokens.setToken(dto.getToken());
            emailTokensDAO.update(emailTokens);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
