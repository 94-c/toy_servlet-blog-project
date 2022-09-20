package com.blog.service;

import com.blog.data.dto.LikeDto;
import com.blog.data.entity.Like;
import com.blog.mapper.LikeMapper;
import org.junit.Test;

import static org.junit.Assert.*;

public class LikeServiceTest {

    private final LikeService likeService = new LikeService();

    @Test
    public void likeSuccess() {
        LikeDto newLikeDto = LikeDto.builder()
                .postId(75)
                .userId(96)
                .build();

        Like newLike = likeService.createLike(newLikeDto);

        assertTrue(newLike != null && newLike.getId() > 0);
    }

}