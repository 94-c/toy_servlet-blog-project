package com.blog.service;

import com.blog.dao.TagDAO;
import com.blog.dto.tag.CreateRequestTagDTO;
import com.blog.entity.Tag;
import com.blog.service.exception.PostServiceException;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Level;

@RequiredArgsConstructor
public class TagService {

    private final TagDAO  tagDAO = new TagDAO();

    public Tag createTage(CreateRequestTagDTO dto) throws PostServiceException {
        Tag newTag = dto.ToEntity();
        Tag result = tagDAO.create(newTag);
        if (result == null) {
            throw new PostServiceException("Create Tag Error", Level.ERROR);
        }
        return newTag;
    }

}
