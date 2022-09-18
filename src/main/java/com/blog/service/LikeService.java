package com.blog.service;

import com.blog.data.dao.LikeDAO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LikeService {

    private final LikeDAO likeDAO = new LikeDAO();

    /*public void createLike(CreateRequestLikeDTO dto) {
        Like like = dto.toEntity();
        likeDAO.create(like);
    }

    public void createNotLike(CreateRequestLikeDTO dto) {
        Like like = dto.toEntity();
        likeDAO.update(like);
    }
*/
}
