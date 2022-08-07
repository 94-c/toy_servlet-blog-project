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

    @Override
    public EmailTokens update(EmailTokens emailTokens) {
        emailTokens.setAuthAt(new Date());
        return super.update(emailTokens);
    }

    public EmailTokens findByToken(String token) {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("token", token);

        List<EmailTokens> emailTokens = super.findWithNamedQuery("emailToken.findByToken", parameters);

        return emailTokens.size() == 1 ? emailTokens.get(0) : null;
    }

}
