package com.blog.dao;

import com.blog.entity.Tag;

import java.util.Date;

public class TagDAO extends JpaDAO<Tag> {

    @Override
    public Tag create(Tag tag) {
        tag.setCreatedAt(new Date());
        return super.create(tag);
    }


}
