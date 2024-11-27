package com.it.bbs.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReasonTypeEnum {
     LJGG   (1,"垃圾广告"),
       WFWG         ( 2,"违法违规"),
          SQBL      ( 3,"色情暴力"),
             WRMM   (  4,"侮辱谩骂"),
               ZZMG (  5,"政治敏感"),
              XJXX  (  6,"虚假信息"),
               XLYS (   7,"泄露隐私"),
              CXQQ  (   8,"抄袭侵权"),
               QT (  9,"其他");

     @EnumValue
     private final Integer code;
     private final String desc;
}
