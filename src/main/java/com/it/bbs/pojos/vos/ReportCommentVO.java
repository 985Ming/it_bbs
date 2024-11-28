package com.it.bbs.pojos.vos;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReportCommentVO {
    private Integer reportId;
    /**
     * 被举报对象的ID（可能是帖子ID或评论ID）
     */
    private Integer targetId;

    /**
     * 被举报对象类型：1-帖子，2-评论
     */
    private Integer targetType;

    /**
     * 举报原因类型：
     1-垃圾广告，
     2-违法违规，
     3-色情暴力，
     4-侮辱谩骂，
     5-政治敏感，
     6-虚假信息，
     7-泄露隐私，
     8-抄袭侵权，
     9-其他
     */
    private Integer reasonType;



    /**
     * 举报处理状态：0-待处理，1-已处理，2-已忽略
     */
    private Integer status;


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
     * 评论的回复数量
     */
    private Integer replyCount;

    /**
     * 头像图片的URL地址
     */

    private String imageUrl;
}
