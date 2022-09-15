package com.blog.data.dto;

import com.blog.data.entity.EmailTokens;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmailConfirmDto {

    private final String token;
    private final Integer userId;

    public EmailTokens toEntity() {
        EmailTokens emailTokens = new EmailTokens();
        emailTokens.setToken(token);
        emailTokens.setUserId(userId);

        return emailTokens;
    }
}
