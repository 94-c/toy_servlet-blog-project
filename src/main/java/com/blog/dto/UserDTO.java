package com.blog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserDTO {

    private Integer id;
    private String email;
    private String password;
    private String name;
    private Integer state;

}
