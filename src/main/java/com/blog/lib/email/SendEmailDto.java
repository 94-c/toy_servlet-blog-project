package com.blog.lib.email;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SendEmailDto {
    private String email;
    private String token;
    private String mailType;
}
