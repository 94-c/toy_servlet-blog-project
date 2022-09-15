package com.blog.dao;

import com.blog.data.dao.EmailTokensDAO;
import com.blog.data.entity.EmailTokens;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTokensDAOTest {

    private final EmailTokensDAO emailTokensDAO = new EmailTokensDAO();

    @Test
    public void createEmailToken_success() {

        EmailTokens emailTokens = new EmailTokens();
        emailTokens.setToken("123456");
        emailTokens.setUserId(165);

        EmailTokens newToken = emailTokensDAO.create(emailTokens);

        assertEquals(emailTokens, newToken);

    }

    @Test(expected = Exception.class)
    public void createEmailToken_fail() {

        EmailTokens emailTokens = new EmailTokens();
        emailTokens.setToken("123456");
        emailTokens.setUserId(1);

        EmailTokens newToken = emailTokensDAO.create(emailTokens);

        assertEquals(emailTokens, newToken);
    }

   @Test
    public void updateAuthState_success() {

        EmailTokens findById = emailTokensDAO.find(81);

        EmailTokens updateState = emailTokensDAO.update(findById);

        assertEquals(findById.getId(), updateState.getId());
   }

    @Test(expected = NullPointerException.class)
    public void updateAuthState_fail() {

        EmailTokens findById = emailTokensDAO.find(1);

        EmailTokens updateState = emailTokensDAO.update(findById);

        assertEquals(findById.getId(), updateState.getId());
    }

    @Test(expected = ClassCastException.class)
    public void findByToken() {
        String token = "123456";

        EmailTokens result = emailTokensDAO.emailTokens(token);

        assertNotEquals(result.getToken(), token);
    }
}