package com.blog.service;

import com.blog.dao.EmailTokensDAO;
import com.blog.dto.email.EmailConfirmRequestDTO;
import com.blog.entity.EmailTokens;
import com.blog.util.ExceptionUtil;


public class EmailTokensService {

    private final EmailTokensDAO emailTokensDAO = new EmailTokensDAO();

    public EmailTokens findByToken(String token) {
        try {
           return emailTokensDAO.emailTokens(token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateState(EmailConfirmRequestDTO dto) {
        EmailTokens result = findByToken(dto.getToken());
        if (result == null) {
            throw new ExceptionUtil("updateState Error");
        }
            result.setToken(result.getToken());
            result.setState(1);
            emailTokensDAO.update(result);
            return true;
    }


}
