package com.blog.dto.comment.parenteComment;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EditRequestParentCommentDTO {

    private final Integer id;
    private final String body;
    private final String userIp;
    private final Integer parentsId;
    private final Integer userId;
    private final Integer postId;

    public Comment ToParentCommentEntity(Comment parentComment) {
        User user = new User();
        user.setId(userId);

        Post post = new Post();
        post.setId(postId);

        parentComment.setId(id);
        parentComment.setPost(post);
        parentComment.setUser(user);
        parentComment.setBody(body);
        parentComment.setUserIp(userIp);
        if (parentsId != null) {
            parentComment.setParentsId(parentsId);
        }

        return parentComment;
    }
}
