package com.blog.data.dao;

import com.blog.data.entity.PostTag;

public class PostTagDAO extends JpaDAO<PostTag> {

    @Override
    public PostTag create(PostTag postTag) {
        postTag.setDeleteState(0);
        return super.create(postTag);
    }
}
