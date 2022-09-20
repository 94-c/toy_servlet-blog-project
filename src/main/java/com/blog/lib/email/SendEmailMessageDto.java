package com.blog.lib.email;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SendEmailMessageDto {
    private String content;
    private String subject;
}
