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
 * 点赞记录表
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("likes")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Likes implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 点赞记录ID，自增主键
     */
    @TableId(value = "like_id", type = IdType.AUTO)
    private Integer likeId;

    /**
     * 被点赞对象的ID（可能是帖子ID或评论ID）
     */
    private Integer targetId;

    /**
     * 点赞对象类型：1-帖子，2-评论
     */
    private Integer targetType;

    /**
     * 点赞设备的唯一标识（可以是cookie或设备指纹）
     */
    private String deviceId;

    /**
     * 点赞时间
     */
    private LocalDateTime createdAt;


}
