package com.blog.service;

import com.blog.dao.EmailTokensDAO;
import com.blog.dto.EmailTokensDTO;
import com.blog.entity.EmailTokens;
import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;


public class EmailTokensService {

    private final HttpServletRequest request;
    private final EmailTokensDAO emailTokensDAO = new EmailTokensDAO();

    public EmailTokensService(HttpServletRequest request) {
        this.request = request;
    }

    public boolean updateState(EmailTokensDTO dto) {
        EmailTokens emailTokens = emailTokensDAO.findByToken(dto.getToken());
        if (emailTokens == null) {
            return false;
        }
        try {
            EmailTokens findByEmailTokenId = emailTokensDAO.find(EmailTokens.class, emailTokens.getId());
            if (findByEmailTokenId == null) {
                return false;
            }
            emailTokensDAO.update(emailTokens);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
