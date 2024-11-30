package com.it.bbs.pojos.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReportPostVO implements Serializable {
    /**
     * 举报记录ID，自增主键
     */

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
     * 帖子正文
     */
    private String content;

    /**
     * 举报处理状态：0-待处理，1-已处理，2-已忽略
     */
    private Integer status;
    /**
     * 举报提交时间
     */
    private LocalDateTime createdAt;

    /**
     * 头像ID，自增主键
     */

    private Integer avatarId;

    /**
     * 头像图片的URL地址
     */

    private String imageUrl;

    /**
     * 帖子ID，自增主键
     */

    private Integer postId;

    /**
     * 发帖人昵称，每次发帖可以自行填写
     */
    private String nickname;
    /**
     * 帖子标题
     */
    private String title;

}
