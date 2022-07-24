package com.blog.dao;

import com.blog.entity.Post;

import java.util.Date;

public class PostDAO extends JpaDAO<Post> {

    @Override
    public Post create(Post entity) {
        entity.setCreatedAt(new Date());
        return super.create(entity);
    }

    @Override
    public Post update(Post entity) {
        entity.setUpdatedAt(new Date());
        return super.update(entity);
    }

}
