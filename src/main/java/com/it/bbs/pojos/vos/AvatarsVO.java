package com.it.bbs.pojos.vos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AvatarsVO {
    /**
     * 头像ID，自增主键
     */
    @TableId(value = "avatar_id", type = IdType.AUTO)
    private Integer avatarId;

    /**
     * 头像图片的URL地址
     */
    private String imageUrl;

}
