package com.blog.dto.tag;

import com.blog.entity.PostTag;
import com.blog.entity.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateRequestTagDTO {

    private final String name;

    public Tag ToEntity() {
        Tag tag = new Tag();

        tag.setName(name);

        return tag;
    }
}
