package com.blog;

import com.blog.entity.Post;
import com.blog.service.PostService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.NoSuchElementException;
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
    public void ifPresent_readPostIdSuccess() {
        Integer postId = 16;
        Optional<Post> result = Optional.ofNullable(postService.findByPostId(postId));

        result.ifPresent(selectPost -> {
            System.out.println(selectPost.getTitle());
            System.out.println(selectPost.getBody());
            System.out.println(selectPost.getUser().getName());
        });
    }

    @Test
    public void ifPresent_readPostIdFail() {
        Integer postId = 99;
        Optional<Post> result = Optional.ofNullable(postService.findByPostId(postId));

        result.ifPresent(selectPost -> {
            System.out.println(selectPost.getTitle());
            System.out.println(selectPost.getBody());
            System.out.println(selectPost.getUser().getName());
        });
    }

    @Test
    public void isPresent_readPostIdSuccess() {
        Integer postId = 16;
        Post result = postService.findByPostId(postId);

        Optional.of(result).isPresent(); //true
    }

    @Test(expected = NullPointerException.class)
    public void isPresent_readPostIdFail() {
        Integer postId = 99;
        Post result = postService.findByPostId(postId);

        Optional.of(result).filter(m -> "존재하지않는 게시물 아이디입니다.".equals(m)).isPresent();
    }

    @Test
    public void get_postIdSuccess() {
        Integer postId = 16;
        Optional<Post> result = Optional.of(postService.findByPostId(postId));

        System.out.println(result.get());
    }

    //NoSuchElementException : 런타임 에러러
   @Test(expected = NoSuchElementException.class)
    public void get_postIdFail() {
        Integer postId = 99;
        Optional<Post> result = Optional.ofNullable(postService.findByPostId(postId));

        System.out.println(result.get().toString());
    }

    @Test
    @DisplayName("postId가 없을 경우에, postId1로 넘어가라")
    public void orElse_postIdSuccess() {
        Integer postId = 99;
        Integer postId1 = 16;
        Post result = Optional.ofNullable(postService.findByPostId(postId)).orElse(postService.findByPostId(postId1));

        System.out.println(result);
    }

    @Test
    @DisplayName("postId가 두가지 다 없을 경우")
    public void orElse_postIdFail() {
        Integer postId = 99;
        Integer postId1 = 100;
        Post result = Optional.ofNullable(postService.findByPostId(postId)).orElse(postService.findByPostId(postId1));

        System.out.println(result);
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
