package com.blog.dao;

import com.blog.entity.EmailTokens;

import java.util.Date;

public class EmailTokensDAO extends JpaDAO<EmailTokens> {


    @Override
    public EmailTokens create(EmailTokens emailTokens) {
        emailTokens.setSendedAt(new Date());
        emailTokens.setState(0);
        return super.create(emailTokens);
    }

    @Override
    public EmailTokens update(EmailTokens emailTokens) {
        emailTokens.setState(1);
        emailTokens.setAuthAt(new Date());
        return super.update(emailTokens);
    }

}
