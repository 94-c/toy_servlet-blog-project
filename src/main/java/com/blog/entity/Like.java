package com.blog.entity;

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
        @NamedQuery(name = "Like_findLikeWithUserAndPostId", query = "SELECT l.post.id, l.user.id FROM Like l INNER JOIN Post p ON p.id = :postId INNER JOIN User u ON u.id = :userId")
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
