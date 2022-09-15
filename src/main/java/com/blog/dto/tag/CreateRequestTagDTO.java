package com.blog.dto.tag;

import com.blog.data.entity.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateRequestTagDTO {

    private final String name;

    public Tag toEntity() {
        Tag tag = new Tag();

        tag.setName(name);

        return tag;
    }
}
