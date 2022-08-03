-- blog_test.tag definition

CREATE TABLE `tag`
(
    `id`         int(11) NOT NULL,
    `name`       varchar(255) DEFAULT NULL,
    `created_at` timestamp NULL DEFAULT current_timestamp (),
    `updated_at` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- blog_test.`user` definition

CREATE TABLE `user`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `email`      varchar(100) DEFAULT NULL,
    `password`   varchar(100) DEFAULT NULL,
    `name`       varchar(100) DEFAULT NULL,
    `state`      tinyint(1) DEFAULT 0 COMMENT '0 = 미인증, 1 = 인증완료',
    `created_at` timestamp NULL DEFAULT current_timestamp (),
    `updated_at` timestamp NULL DEFAULT NULL,
    `deleted_at` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;


-- blog_test.user_login_logs definition

CREATE TABLE `user_login_logs`
(
    `id`         bigint(20) NOT NULL,
    `user_id`    int(11) DEFAULT NULL,
    `user_ip`    varchar(15) DEFAULT NULL,
    `user_agent` text        DEFAULT NULL,
    `created_at` timestamp NULL DEFAULT current_timestamp (),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- blog_test.email_tokens definition

CREATE TABLE `email_tokens`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `user_id`    int(11) DEFAULT NULL,
    `token`      varchar(100) DEFAULT NULL,
    `auth_at`    timestamp NULL DEFAULT NULL COMMENT '링크를 클릭한 시간',
    `state`      tinyint(1) DEFAULT 1 COMMENT '1:회원가입\r\n2:비밀번호 변경',
    `sended_at`  timestamp NULL DEFAULT NULL COMMENT '인증 메일을 보낸 시간',
    `deleted_at` timestamp NULL DEFAULT NULL COMMENT '삭제',
    PRIMARY KEY (`id`),
    KEY          `email_tokens_FK` (`user_id`),
    CONSTRAINT `email_tokens_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


-- blog_test.posts definition

CREATE TABLE `posts`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `title`      varchar(100) DEFAULT NULL,
    `body`       text         DEFAULT NULL,
    `user_id`    int(11) DEFAULT NULL,
    `deleted_at` timestamp NULL DEFAULT NULL COMMENT '게시글 삭제 시 추가',
    `created_at` timestamp NULL DEFAULT current_timestamp (),
    `updated_at` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY          `posts_FK` (`user_id`),
    CONSTRAINT `posts_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;


-- blog_test.comments definition

CREATE TABLE `comments`
(
    `id`                 int(11) NOT NULL AUTO_INCREMENT,
    `body`               text         DEFAULT NULL,
    `user_id`            int(11) DEFAULT NULL,
    `post_id`            int(11) DEFAULT NULL,
    `user_ip`            varchar(100) DEFAULT NULL,
    `parents_comment_id` int(11) DEFAULT NULL,
    `delete_state`       tinyint(1) DEFAULT 0 COMMENT '0 = 미삭제, 1=삭제',
    `created_at`         timestamp NULL DEFAULT current_timestamp (),
    `updated_at`         timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY                  `comments_FK_1` (`post_id`),
    KEY                  `comments_FK` (`user_id`),
    CONSTRAINT `comments_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `comments_FK_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;


-- blog_test.`like` definition

CREATE TABLE `like`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `post_id` int(11) DEFAULT NULL,
    `user_id` int(11) DEFAULT NULL,
    `type`    varchar(1) DEFAULT NULL COMMENT 'g = 좋아요 b = 싫어요',
    PRIMARY KEY (`id`),
    KEY       `like_FK` (`post_id`),
    KEY       `like_FK_1` (`user_id`),
    CONSTRAINT `like_FK` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
    CONSTRAINT `like_FK_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- blog_test.post_tag definition

CREATE TABLE `post_tag`
(
    `post_id`      int(11) DEFAULT NULL,
    `tag_id`       int(11) DEFAULT NULL,
    `delete_state` tinyint(1) DEFAULT NULL COMMENT '0=미삭제, 1=삭제',
    KEY            `post_id` (`post_id`),
    KEY            `tag_id` (`tag_id`),
    CONSTRAINT `post_tag_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
    CONSTRAINT `post_tag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;