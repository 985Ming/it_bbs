package com.it.bbs.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public enum ReportStatusEnum {


DAICL(0,"待处理"),
YICL(1,"已处理"),
YIHL(2,"已忽略");
@EnumValue
private final Integer value;
private final String desc;

}
