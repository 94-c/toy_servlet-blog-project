package com.blog.service;

import com.blog.data.dao.TagDAO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TagService {

    private final TagDAO  tagDAO = new TagDAO();


}
