package com.it.bbs.pojos.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostDetailVO {
    /**
     * 帖子ID，自增主键
     */
    @TableId(value = "post_id", type = IdType.AUTO)
    private Integer postId;

    /**
     * 发帖人昵称，每次发帖可以自行填写
     */
    private String nickname;

    /**
     * 发帖人选择的头像ID，关联avatars表
     */
    private Integer avatarId;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子正文内容
     */
    private String content;

    /**
     * 发帖时间
     */
    private LocalDateTime createdAt;

    /**
     * 最后更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 帖子浏览次数
     */
    private Integer views;

    /**
     * 帖子获得的点赞数
     */
    private Integer likes;

    /**
     * 帖子状态：1-正常，0-删除，2-置顶，3-隐藏
     */
    private Integer status;
    /**
     * 头像图片的URL地址
     */
    private String imageUrl;


}
