package com.blog.service;

import com.blog.data.dao.TagDAO;
import com.blog.data.entity.Post;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class TagService {

    private final TagDAO  tagDAO = new TagDAO();

    public void createTagList(Post post) {
        List<String> tagList = new ArrayList<>();
    }
}
