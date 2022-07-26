package com.blog.dao;

import com.blog.entity.Post;

import java.util.Date;
import java.util.List;

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

    public List<Post> findAllCreateQuery() {
        return super.findWithNamedQuery("Post.findAll");
    }

    public List<Post> findWithNamedQuery(Integer id) {
        return super.findWithNamedQuery("Post.findById", "id", id);
    }
}
