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
 * 预设头像表
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("avatars")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Avatars implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 头像ID，自增主键
     */
    @TableId(value = "avatar_id", type = IdType.AUTO)
    private Integer avatarId;

    /**
     * 头像图片的URL地址
     */

    private String imageUrl;

    /**
     * 头像创建时间
     */
    private LocalDateTime createdAt;


}
