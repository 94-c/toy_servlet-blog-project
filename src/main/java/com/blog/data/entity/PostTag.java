package com.blog.data.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "post_tage")
@Getter
@Setter
@ToString
public class PostTag {

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Column(name = "delete_state", columnDefinition = "tinyint(1) default 0")
    private Integer deleteState;

}
