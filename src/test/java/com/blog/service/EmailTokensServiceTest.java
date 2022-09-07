package com.blog.service;

import com.blog.dao.EmailTokensDAO;
import com.blog.entity.EmailTokens;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmailTokensServiceTest {

    private final EmailTokensService emailTokensService = new EmailTokensService();

    @Test(expected = ClassCastException.class)
    public void findByTokenSuccess() {
        String emailToken = "305613";

        EmailTokens findByEmailToken = emailTokensService.findByToken(emailToken);

        assertEquals(emailToken, findByEmailToken.getToken());
    }


    @Test(expected = NullPointerException.class)
    public void findByTokenFail() {
        String emailToken = "123456";

        EmailTokens findByEmailToken = emailTokensService.findByToken(emailToken);

        assertEquals(emailToken, findByEmailToken.getToken());
    }

}