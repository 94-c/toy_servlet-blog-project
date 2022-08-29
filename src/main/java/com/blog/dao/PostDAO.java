package com.blog.dao;

import com.blog.entity.Post;

import java.util.Date;
import java.util.List;

public class PostDAO extends JpaDAO<Post> {

    @Override
    public Post create(Post post) {
        post.setCreatedAt(new Date());
        return super.create(post);
    }

    public Post find(Object id) {
        return super.find(Post.class, id);
    }

    @Override
    public Post update(Post post) {
        post.setUpdatedAt(new Date());
        return super.update(post);
    }

    public List<Post> findAllPostList() {
        return super.findWithNamedQuery("Post.findAll");
    }

    public Post deleteUpdate(Post post) {
        post.setDeletedAt(new Date());
        return super.update(post);
    }
}
