package com.blog.dao;

import com.blog.entity.EmailTokens;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailTokensDAO extends JpaDAO<EmailTokens> {


    @Override
    public EmailTokens create(EmailTokens emailTokens) {
        emailTokens.setState(0);
        emailTokens.setSendedAt(new Date());
        return super.create(emailTokens);
    }

    public EmailTokens find(Integer id) {
        return super.find(EmailTokens.class, id);
    }

    @Override
    public EmailTokens update(EmailTokens emailTokens) {
        emailTokens.setAuthAt(new Date());
        return super.update(emailTokens);
    }

    public EmailTokens emailTokens(String token) {
        List<EmailTokens> result = super.findWithNamedQuery("emailToken.findByToken", "token", token);
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

}
