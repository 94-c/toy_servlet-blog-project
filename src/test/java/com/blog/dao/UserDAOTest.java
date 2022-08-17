package com.blog.dao;

import com.blog.entity.User;
import com.blog.util.Md5Util;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDAOTest {

    private final UserDAO dao = new UserDAO();

    @Test
    public void createUserSuccess() {

        User user = new User();
        user.setEmail("hyeongwoo26@ggg.ggg");
        user.setPassword(Md5Util.md5("1234"));
        user.setName("가나다라마바사");

        User result = dao.create(user);

        assertEquals(user, result);
    }

    @Test(expected = Exception.class)
    public void createUserFail() {

        User user = new User();
        user.setEmail("hyeongwoo26@ggg.ggg");
        user.setPassword(Md5Util.md5("1234"));
        user.setName("가나다라마바사");

        User emailCheck = dao.emailCheck(user.getEmail());

        if (emailCheck != null) {
            System.out.println("이메일 중복");
        }
        User result = dao.create(user);

        assertEquals(user, result);
    }

    @Test
    public void findByUserIdSuccess() {
        Integer id = 1;

        User findId = dao.find(id);

        assertNotEquals(findId, id);
    }


    @Test
    public void updateSuccess() {
        User user = new User();
        user.setId(89);
        user.setEmail("hyeongwoo26@naver.com");
        user.setPassword(Md5Util.md5("1234"));
        user.setName("최형우");

        User result = dao.update(user);

        assertEquals(User.class, result.getClass());
    }

    @Test(expected = AssertionError.class)
    public void updateUserFail() {
        User user = new User();
        user.setId(1);
        user.setEmail("hyeongwoo26@naver.com");
        user.setPassword(Md5Util.md5("1234"));
        user.setName("최형우");

        User result = dao.update(user);

        assertNotEquals(result, user);
    }

    @Test
    public void loginSuccess() {
        String email = "hyeongwoo26@naver.com";
        String password = Md5Util.md5("1234");

        User loginCheck = dao.login(email, password);

        assertEquals(email, loginCheck.getEmail());
        assertEquals(password, loginCheck.getPassword());
    }

    @Test(expected = Exception.class)
    public void loginFail() {
        String email = "hyeongwoo26@naver.com";
        String password = Md5Util.md5("123231234");

        User loginCheck = dao.login(email, password);

        assertEquals(email, loginCheck.getEmail());
        assertEquals(password, loginCheck.getPassword());
    }

    @Test
    public void emailCheckSuccess() {
        String email = "hyeongwoo26@123123.com";

        User emailCheck = dao.emailCheck(email);

        assertNotEquals(email, emailCheck.getEmail());
    }
}