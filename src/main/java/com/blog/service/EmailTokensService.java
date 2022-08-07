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

    public EmailTokens findByToken(String token) {
        try {
            EmailTokens emailTokens = emailTokensDAO.emailTokens(token);
            return emailTokens;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateState(EmailTokensDTO dto) {
        EmailTokens result = findByToken(dto.getToken());
        if (result == null) {
            return false;
        }
        try {
            EmailTokens findByEmailTokenId = emailTokensDAO.find(EmailTokens.class, result.getId());
            if (findByEmailTokenId == null) {
                return false;
            }
            result.setState(1);
            emailTokensDAO.update(result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}
