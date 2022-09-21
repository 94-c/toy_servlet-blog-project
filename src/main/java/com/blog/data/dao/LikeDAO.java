package com.blog.data.dao;

import com.blog.data.entity.Like;

public class LikeDAO extends JpaDAO<Like> {

    @Override
    public Like create(Like like) {
        like.setType("g");
        return super.create(like);
    }

    @Override
    public Like update(Like like) {
        like.setType("b");
        return super.update(like);
    }

    public long count(Integer postId) {
        return super.countWithNamedQuery("findLike", "postId", postId);
    }

}
