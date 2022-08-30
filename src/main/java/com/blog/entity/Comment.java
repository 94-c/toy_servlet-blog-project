package com.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
@NamedQueries({
        @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c INNER JOIN User u ON c.user.id = u.id INNER JOIN Post p ON c.post.id = p.id WHERE c.deleteState = 0 AND c.post.id = :postId"),
        @NamedQuery(name = "Comment.findByParentComment", query = "SELECT c FROM Comment c INNER JOIN User u ON c.user.id = u.id WHERE c.deleteState = 0 AND c.parentsId = :commentId")
})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = true)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String body;

    @Column(name = "user_ip")
    private String userIp;

    @Column(name = "parents_comment_id")
    private Integer parentsId;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "delete_state", columnDefinition = "tinyint(1) default 0")
    private Integer deleteState;


}
