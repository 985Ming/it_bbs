package com.it.bbs.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 内容举报表
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("reports")
public class Reports implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 举报记录ID，自增主键
     */
    @TableId(value = "report_id", type = IdType.AUTO)
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
     * 举报补充说明，选填
     */
    private String reasonContent;

    /**
     * 举报处理状态：0-待处理，1-已处理，2-已忽略
     */
    private Integer status;

    /**
     * 举报提交时间
     */
    private LocalDateTime createdAt;

    /**
     * 举报更新时间（如处理时间）
     */
    private LocalDateTime updatedAt;


}
