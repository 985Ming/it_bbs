package com.it.bbs.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CommentsStatusEnum {
    NORMAL(1, "正常", "NORMAL"),
    DELETED(0, "删除", "DELETED"),

    HIDDEN(2, "隐藏", "HIDDEN");

  @EnumValue
    private final Integer status;
    private final String desc;
    private final String code;
}
