package com.it.bbs.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.scheduling.annotation.EnableAsync;

@Getter
@AllArgsConstructor
public enum TargetTypeEnum {
TIEZI(1,"帖子"),
PINGLUN(2,"评论");
@EnumValue
private final Integer value;
private final String desc;
}
