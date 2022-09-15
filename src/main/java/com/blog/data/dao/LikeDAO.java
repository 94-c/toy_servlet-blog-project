package com.blog.data.dao;

import com.blog.data.entity.Like;

public class LikeDAO extends JpaDAO<Like> {

    @Override
    public Like create(Like like) {
        like.setType(1);
        return super.create(like);
    }

    @Override
    public Like update(Like like) {
        like.setType(0);
        return super.update(like);
    }
}