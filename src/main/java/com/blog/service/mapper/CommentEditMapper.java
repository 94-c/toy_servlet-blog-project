package com.blog.service.mapper;

import com.blog.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class CommentEditMapper {

    private final Comment comment;
    private final List<Comment> parentCommentList;

}
