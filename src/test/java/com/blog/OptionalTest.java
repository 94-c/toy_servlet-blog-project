package com.blog;

import com.blog.dao.PostDAO;
import com.blog.entity.Post;
import com.blog.service.PostService;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    private final PostService postService = new PostService();

    @Test
    public void optionalTestSuccess() {
        Integer id = 16;

        Optional<Post> post = Optional.ofNullable(postService.findByPostId(id));
        post.ifPresent(value -> System.out.println(value.getTitle()));

        Optional<Post> post1 = Optional.of(post.get());
        System.out.println(post1.get().getTitle());

        Post resultPost = post.orElseGet(Post::new);
        System.out.println(resultPost.getTitle());

    }

    @Test
    public void optionalTestFail() {
        Integer id = 1;

        Optional<Post> post = Optional.ofNullable(postService.findByPostId(id));
        post.ifPresent(value -> System.out.println(value.getTitle()));

        /*Optional<Post> post1 = Optional.of(post.get());
        System.out.println(post1.get().getTitle());*/

        //Null일 경우 Return 값을 null
        Post resultPost = post.orElseGet(Post::new);
        System.out.println(resultPost.getTitle());

    }

    @Test
    public void readPostId() {
        Integer postId = 16;
        Optional<Post> result = Optional.ofNullable(postService.findByPostId(postId));

        //select SQL문법이 진행 된 가정
        //ifPresent는 특정 결과를 반환하지 않음
        result.ifPresent(selectPost -> {
            System.out.println(selectPost.getTitle());
            System.out.println(selectPost.getBody());
            System.out.println(selectPost.getUser().getName());
        });
    }

    @Test
    public void isPresentReadPostId() {
        Integer postId = 16;
        Optional<Post> result = Optional.ofNullable(postService.findByPostId(postId));

        //isPresent는 특정 결과를 반환 X, optional의 값이 null인지 확인
        Assert.assertEquals(false, result.isPresent());
    }
}
