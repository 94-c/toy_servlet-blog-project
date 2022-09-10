package com.blog.dto.postTag;

import com.blog.entity.Post;
import com.blog.entity.PostTag;
import com.blog.entity.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateRequestPostTagDTO {

    private final Integer postId;
    private final Integer tagId;

    public PostTag toEntity() {
        Post post = new Post();
        post.setId(postId);

        Tag tag = new Tag();
        tag.setId(tagId);

        PostTag postTag = new PostTag();
        postTag.setPost(post);
        postTag.setTag(tag);

        return postTag;
    }
}
