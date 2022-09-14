package com.blog.service;

import com.blog.dao.CommentDAO;
import com.blog.dao.PostDAO;
import com.blog.dao.PostTagDAO;
import com.blog.dao.TagDAO;
import com.blog.dto.post.CreateRequestPostDTO;
import com.blog.dto.post.EditRequestPostDTO;
import com.blog.dto.postTag.CreateRequestPostTagDTO;
import com.blog.dto.tag.CreateRequestTagDTO;
import com.blog.entity.PostTag;
import com.blog.entity.Tag;
import com.blog.responseDto.EditResponsePostEditDto;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.service.exception.PostServiceException;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Level;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PostService {

    private final PostDAO postDAO = new PostDAO();
    private final CommentDAO commentDAO = new CommentDAO();
    private final PostTagDAO postTagDAO = new PostTagDAO();
    private final TagDAO tagDAO = new TagDAO();

    public List<Post> findAllPost() {
        return postDAO.findAllPostList();
    }


    public Post createPost(CreateRequestPostDTO dto) throws PostServiceException {
        Post post = dto.toEntity();
        Tag tag = new Tag();
        //TODO addTag라는 클래스 안에 dao를 하나로 통합 
        post.addTag(tag1);
        post.addTag(tag2);
        post.addTag(tag3);
        post.addTag(tag4);
        Post newPost = postDAO.create(post);
        if (newPost == null) {
            throw new PostServiceException("Create Post Error", Level.ERROR);
        }
        return newPost;
    }

    /**
     * 생각 포인트
     * - 작업 이벤트 별 요구하는 일의 볼륨
     * 1. 댓글 작성
     * - find
     * - insert
     * - update
     *
     * 2. 댓글 읽을때 : 데이터가 많으면 예를 들어 10만건이라고 하면 데이더를 메모리에 넣고 정렬 작업을 하는데 데이터 가져오는 시간보다 정렬하는 시간이 도 많이 걸린다
     * 10 건 4초 5초
     * 10만건 정렬 10 ~ 15 or 20 이상 timeout 30
     *
     * 3. 댓글 삭제
     *
     * 일반적인 코멘트 테이블의 구조
     * comments table 2 depth
     * id, post_id(FK), user_id, body, ip_address, parendt_id, created_at, updated_at, deleted_at
     * order by num, created_at asc
     * comments table 무한궤도 depth
     * id(PK), post_id(FK), user_id, body, ip_address, level(Index), parent_id(Index), created_at(Index), updated_at, deleted_at
     * 1, 20, 104, test, 127.0.0.1, 0, null, time
     * 2, 20, 109, test & test, 127.0.0.1, 1, 1, time = 2
     * 3, 20, 9, test & test & test, 127.0.0.1, 2, 2, time = 3
     * 4, 20, 912, test 2, 127.0.0.1, 0, null, time
     * 5, 20, 2, test 2, 127.0.0.1, 2, 2, time = 3
     *
     * select * form comments where post_id = order by position asc;
     *
     * maxPosition = select max(position) from comments where post_id = and parent_id = ;
     * update position = position + 1 where post_id = and parent_id =  position >= maxPosition
     * insert maxPosition + 1
     * comments table 무한궤도 depth 작성할 때 잘 해보자
     * id(PK), post_id(FK), user_id, body, ip_address, level, parent_id(I), position(I), created_at(Index), updated_at, deleted_at
     * 1, 20, 104, test, 127.0.0.1, 0, null, 1, time
     * 2, 20, 109, test & test, 127.0.0.1, 1, 1, 2, time
     * 3, 20, 9, test & test & test, 127.0.0.1, 2, 2, 3 time
     * 4, 20, 912, test 2, 127.0.0.1, 0, null, 5, time
     * 5, 20, 2, test 2, 127.0.0.1, 2, 2, 4, time
     *
     * @param id
     * @return
     * @throws PostServiceException
     */
    public EditResponsePostEditDto findByPostId(Integer id) throws PostServiceException {
        Post findById = postDAO.find(id);
        if (findById == null) {
            throw new PostServiceException("findByPostId Error", Level.ERROR);
        }

        List<Comment> mergeComments = new ArrayList<>();
        List<Comment> comments = commentDAO.findAllCommentByPostId(id);
        comments.forEach(comment -> {
            mergeComments.add(comment);

            // find child comment and add comments
            List<Comment> childComment = commentDAO.findAllParentCommentList(comment.getId());
            if (childComment.size() > 0) {
                mergeComments.addAll(childComment);
            }
        });

        return EditResponsePostEditDto.builder()
                .post(findById)
                .commentList(mergeComments)
                .build();
    }

    public Post updatePost(EditRequestPostDTO dto) throws PostServiceException {
        Post findById = postDAO.find(dto.getId());
        if (findById == null) {
            throw new PostServiceException("findByPostId Error", Level.ERROR);
        }
        Post updatePostDto = dto.toEntity(findById);
        Post updatePost = postDAO.update(updatePostDto);
        if (updatePost == null) {
            throw new PostServiceException("updatePost Error", Level.ERROR);
        }
        return updatePost;
    }


    /*public boolean deletePost(PostDTO dto) {
        Post post = postDAO.find(dto.getId());
        if (post == null) {
            return false;
        }
        try {
            addPostField(post, dto);
            postDAO.deleteUpdate(post);
        } catch (ExceptionUtil e) {
            throw new ExceptionUtil("Error delete Post");
        }
        return true;
    }*/

}
