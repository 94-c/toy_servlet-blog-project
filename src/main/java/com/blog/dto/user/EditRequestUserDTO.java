package com.blog.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EditRequestUserDTO {

    private final Integer id;
    private final String email;
    private final String password;
    private final String name;
    private final Integer state;


}
