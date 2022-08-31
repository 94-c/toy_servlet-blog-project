package com.blog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRequestDTO {

    private String email;
    private String password;

}
