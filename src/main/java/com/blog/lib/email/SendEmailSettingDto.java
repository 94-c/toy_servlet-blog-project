package com.blog.lib.email;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SendEmailSettingDto {
    private String host;
    private String guest;
    private String password;
}
