package com.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "email_tokens")
@Getter
@Setter
@ToString
public class EmailTokens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "auth_at")
    private Date authAt;

    @Column(columnDefinition = "tinyint(1) default 0")
    private Integer state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sended_at")
    private Date sendedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at")
    private Date deletedAt;

}
