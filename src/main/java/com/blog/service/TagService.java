package com.blog.service;

import com.blog.dao.TagDAO;
import com.blog.dto.tag.CreateRequestTagDTO;
import com.blog.entity.Tag;
import com.blog.util.ExceptionUtil;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TagService {

    private final TagDAO  tagDAO = new TagDAO();

    public Tag createTage(CreateRequestTagDTO dto) {
        Tag newTag = dto.ToEntity();
        Tag result = tagDAO.create(newTag);
        if (result == null) {
            throw new ExceptionUtil("Create Tag Error");
        }
        return newTag;
    }

}
