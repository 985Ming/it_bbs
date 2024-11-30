package com.it.bbs.pojos.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class CommentDTO implements Serializable {
    /**
     * 评论所属的帖子ID，关联posts表
     */
    private Integer postId;

    /**
     * 父评论ID，用于回复功能，若为主评论则为null
     */
    private Integer parentId;

    /**
     * 评论人昵称，每次评论可以自行填写
     */
    private String nickname;

    /**
     * 评论人选择的头像ID，关联avatars表
     */
    private Integer avatarId;

    /**
     * 评论内容
     */
    private String content;

}
