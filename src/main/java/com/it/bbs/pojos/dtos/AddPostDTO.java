package com.it.bbs.pojos.dtos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AddPostDTO implements Serializable {




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






}
