package com.blog.request.post;

import javax.servlet.http.HttpServletRequest;

public interface Request<D> {
    public D toDto(HttpServletRequest request);
}
