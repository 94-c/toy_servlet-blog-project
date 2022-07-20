package com.blog.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class EmailTokensDTO {

    private Integer id;
    private Integer userId;
    private String token;
    private Date authAt;
    private Integer state;
    private Date sendedAt;
    private Date deleteAt;

}
