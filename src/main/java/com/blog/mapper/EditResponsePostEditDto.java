package com.blog.mapper;

import com.blog.data.entity.Comment;
import com.blog.data.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class EditResponsePostEditDto {

    private final Post post;
    private final List<Comment> commentList;
    private final List<Comment> parentCommentList;

}
