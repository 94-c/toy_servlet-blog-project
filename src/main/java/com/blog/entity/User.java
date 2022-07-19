package com.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
@NamedQuery(name = "User_Login_Check", query = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    private String name;

    @Column(columnDefinition = "tinyint(1) default 0")
    private Integer state;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;
}
