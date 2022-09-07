package com.blog.service;

import com.blog.dao.EmailTokensDAO;
import com.blog.dto.email.EmailConfirmRequestDTO;
import com.blog.entity.EmailTokens;
import com.blog.service.exception.PostServiceException;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Level;


@RequiredArgsConstructor
public class EmailTokensService {

    private static final EmailTokensDAO emailTokensDAO = new EmailTokensDAO();

    public EmailTokens findByToken(String token) {
        try {
           return emailTokensDAO.emailTokens(token);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateState(EmailConfirmRequestDTO dto) throws PostServiceException {
        EmailTokens result = findByToken(dto.getToken());
        if (result == null) {
            throw new PostServiceException("updateState Error", Level.ERROR);
        }

        result.setToken(result.getToken());
        result.setState(1);
        emailTokensDAO.update(result);
        return true;
    }


}
