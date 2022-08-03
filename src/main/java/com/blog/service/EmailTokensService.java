package com.blog.service;

import com.blog.dao.EmailTokensDAO;
import com.blog.dto.EmailTokensDTO;
import com.blog.entity.EmailTokens;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;


@RequiredArgsConstructor
public class EmailTokensService {

    private final HttpServletRequest request;
    private final EmailTokensDAO emailTokensDAO = new EmailTokensDAO();

    public boolean createTokens(EmailTokensDTO dto) {
        try {
            EmailTokens emailTokens = new EmailTokens();
            emailTokens.setUserId(dto.getUserId());
            emailTokens.setToken(dto.getToken());
            emailTokensDAO.create(emailTokens);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateState(EmailTokensDTO dto) {
        EmailTokens emailTokens = emailTokensDAO.find(EmailTokens.class, dto.getId());
        if (emailTokens == null) {
            return false;
        }
        try {
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
