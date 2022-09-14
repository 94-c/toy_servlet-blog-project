package com.blog.service;

import com.blog.dao.LikeDAO;
import com.blog.dto.like.CreateRequestLikeDTO;
import com.blog.entity.Like;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LikeService {

    private final LikeDAO likeDAO = new LikeDAO();

    public void createLike(CreateRequestLikeDTO dto) {
        Like like = dto.toEntity();
        likeDAO.create(like);
    }

    public void createNotLike(CreateRequestLikeDTO dto) {
        Like like = dto.toEntity();
        likeDAO.update(like);
    }

}