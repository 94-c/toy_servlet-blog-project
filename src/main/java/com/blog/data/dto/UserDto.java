package com.blog.data.dto;

import com.blog.data.entity.User;
import com.blog.util.Md5Util;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {
    private final Integer id;
    private final String email;
    private final String password;
    private final String name;
    private final Integer state;

    public User toCreateEntity() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(Md5Util.md5(password));
        user.setName(name);

        return user;
    }

    public User toEditEntity(User user) {
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setState(state);

        return user;
    }

    public User toLoginEntity() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }



}
