package com.blog.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "like")
@Getter
@Setter
@ToString
@NamedQueries(
        @NamedQuery(name = "like_check", query = "UPDATE Like l SET l.type = l.type + 1")
)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer type;

}
