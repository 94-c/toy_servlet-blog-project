package com.blog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserLogDTO {

    private Integer id;
    private Integer userId;
    private String userIp;
    private String userAgent;

}
