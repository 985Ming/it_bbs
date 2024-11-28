package com.it.bbs.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.bbs.pojos.dtos.PageQueryDTO;
import com.it.bbs.pojos.entity.Reports;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.bbs.pojos.vos.ReportCommentVO;
import com.it.bbs.pojos.vos.ReportPostVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 内容举报表 Mapper 接口
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
public interface ReportsMapper extends BaseMapper<Reports> {

    Page<ReportPostVO> getReportPost(Page<Reports> mpPage,@Param("sort_by") String sort_by,@Param("sort_order") String sort_order);

    Page<ReportCommentVO> getReportComment(Page<Reports> page1,@Param("sort_by") String sort_by,@Param("sort_order") String sort_order);
}
