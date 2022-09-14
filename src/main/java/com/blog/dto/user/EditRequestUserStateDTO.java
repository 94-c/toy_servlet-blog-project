package com.blog.dto.user;

import com.blog.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EditRequestUserStateDTO {

    private final Integer id;
    private final String email;
    private final String password;
    private final String name;
    private final Integer state;

    public User toEntity(User user) {
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setState(state);

        return user;
    }
}
