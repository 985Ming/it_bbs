package com.it.bbs.service;

import com.it.bbs.pojos.dtos.ReportDTO;
import com.it.bbs.pojos.entity.Reports;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 内容举报表 服务类
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
public interface IReportsService extends IService<Reports> {
    /**
     * 举报帖子
     * @param postId
     */
    void reportPost(Integer postId, ReportDTO reportDTO);
}
