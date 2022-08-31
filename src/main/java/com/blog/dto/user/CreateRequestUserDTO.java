package com.blog.dto.user;

import com.blog.entity.User;
import com.blog.util.Md5Util;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateRequestUserDTO {

    private final String email;
    private final String password;
    private final String name;
    private final Integer state;

    public User ToEntity() {
        User user = new User();
        user.setEmail(email);
        user.setPassword(Md5Util.md5(password));
        user.setName(name);

        return user;
    }

}
