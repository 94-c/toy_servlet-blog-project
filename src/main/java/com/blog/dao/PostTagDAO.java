package com.blog.dao;

import com.blog.entity.PostTag;

public class PostTagDAO extends JpaDAO<PostTag> {

    @Override
    public PostTag create(PostTag postTag) {
        postTag.setDeleteState(0);
        return super.create(postTag);
    }
}
