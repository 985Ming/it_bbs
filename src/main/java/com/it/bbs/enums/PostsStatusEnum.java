package com.it.bbs.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author itcast
 */
@Getter
@AllArgsConstructor
public enum PostsStatusEnum  {
    NORMAL(1, "正常", "NORMAL"),
    DELETED(0, "已删除", "DELETED"),
    TOP(2, "置顶", "TOP"),
 HIDDEN(3, "隐藏", "HIDDEN");

  //  帖子状态：1-正常，0-删除，2-置顶，3-隐藏
    private final Integer status;
    private final String desc;
    private final String code;

    /**
     * 根据状态值获得对应枚举
     *
     * @param status 状态
     * @return 状态对应枚举
     */
    public static PostsStatusEnum codeOf(Integer status) {
        for (PostsStatusEnum postsStatusEnum : values()) {
            if (postsStatusEnum.status.equals(status)) {
                return postsStatusEnum;
            }
        }
        return null;
    }
}
