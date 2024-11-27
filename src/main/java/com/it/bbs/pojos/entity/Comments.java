package com.it.bbs.pojos.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 帖子评论表
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("comments")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID，自增主键
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

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

    /**
     * 评论发布时间
     */
    private LocalDateTime createdAt;

    /**
     * 评论获得的点赞数
     */
    private Integer likes;

    /**
     * 评论状态：1-正常，0-删除，2-隐藏
     */
    private Integer status;

    /**
     * 评论的回复数量
     */
    private Integer replyCount;


}
