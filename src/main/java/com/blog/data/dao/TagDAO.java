package com.blog.data.dao;

import com.blog.data.entity.Tag;

import java.util.Date;

public class TagDAO extends JpaDAO<Tag> {

    @Override
    public Tag create(Tag tag) {
        tag.setCreatedAt(new Date());
        return super.create(tag);
    }

    public Tag find(Object tag) {
        return super.find(Tag.class, tag);
    }


}
