package com.blog.service;

import com.blog.data.dao.LikeDAO;
import com.blog.data.dto.LikeDto;
import com.blog.data.entity.Like;
import com.blog.service.exception.LikeServiceException;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Level;

@RequiredArgsConstructor
public class LikeService {

    private final LikeDAO likeDAO = new LikeDAO();

    public Like createLike(LikeDto dto) {
        Like likeDto = dto.toCreateEntity();
        return likeDAO.create(likeDto);
    }

}
