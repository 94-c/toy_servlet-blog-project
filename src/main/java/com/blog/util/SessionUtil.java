package com.blog.util;

import javax.servlet.http.HttpSession;

public class SessionUtil {
    private static SessionUtil sessionUtil;
    private HttpSession session;
    private SessionUtil() {
    }

    public static SessionUtil getInstance() {
        return sessionUtil;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }



    public SessionUtil set(String key, Object value) {
        session.setAttribute(key, value);
        return sessionUtil;
    }
}
