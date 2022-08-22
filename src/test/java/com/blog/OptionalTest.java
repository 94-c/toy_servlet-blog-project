package com.blog;

import com.blog.dao.PostDAO;
import com.blog.entity.Post;
import com.blog.service.PostService;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

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

        Post resultPost = post.orElseGet(Post::new);
        System.out.println(resultPost.getTitle());

    }

    @Test
    public void readPostId() {
        Integer postId = 16;
        Optional<Post> result = Optional.ofNullable(postService.findByPostId(postId));

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
        assertEquals(false, result.isPresent());
    }

    @Test
    public void getPostTitle() {
        Optional<String> t = Optional.of("123");
        String title = t.get();

        assertEquals("123", title);
    }

    @Test
    public void getPostTitle2() {
        Integer postId = 16;
        Post post = postService.findByPostId(postId);

        Optional.of(post)
                .map(Post::getTitle)
                .ifPresent(a -> System.out.println("title : " + a));
        System.out.println("title : " + post.getTitle());

    }


}
