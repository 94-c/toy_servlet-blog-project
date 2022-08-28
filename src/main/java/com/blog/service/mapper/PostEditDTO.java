package com.blog.service.mapper;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PostEditDTO {

    private final Post post;
    private final List<Comment> commentList;
}
