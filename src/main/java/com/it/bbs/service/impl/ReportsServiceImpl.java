package com.it.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.bbs.enums.*;
import com.it.bbs.pojos.dtos.PageQueryDTO;
import com.it.bbs.pojos.dtos.ReportDTO;
import com.it.bbs.pojos.entity.Comments;
import com.it.bbs.pojos.entity.Posts;
import com.it.bbs.pojos.entity.Reports;
import com.it.bbs.mapper.ReportsMapper;
import com.it.bbs.pojos.result.PageResult;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.ReportCommentVO;
import com.it.bbs.pojos.vos.ReportPostVO;
import com.it.bbs.service.ICommentsService;
import com.it.bbs.service.IPostsService;
import com.it.bbs.service.IReportsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 内容举报表 服务实现类
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@Service
public class ReportsServiceImpl extends ServiceImpl<ReportsMapper, Reports> implements IReportsService {
   @Autowired
   private IPostsService postsService;
   @Autowired
   private ICommentsService commentsService;
    /**
     * 举报帖子 添加
     * @param postId
     */
    @Override
    @Transactional
    public void reportPost(Integer postId, ReportDTO reportDTO) {
        //把举报信息填充数据库
        Reports reports=new Reports();
        reports.setTargetId(postId);
        reports.setTargetType(TargetTypeEnum.TIEZI.getValue());
        reports.setReasonType(reportDTO.getReason_type());
        reports.setReasonContent(reportDTO.getReason_content());
        reports.setCreatedAt(LocalDateTime.now());
        reports.setUpdatedAt(LocalDateTime.now());
        reports.setStatus(ReportStatusEnum.DAICL.getValue());
        save(reports);
        //更新帖子状态
        LambdaUpdateWrapper<Posts> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(Posts::getPostId,postId).set(Posts::getStatus, PostsStatusEnum.HIDDEN.getStatus());
       postsService.update(wrapper);
    }

    /**
     * 获取举报帖子
     * @param pageQueryDTO
     * @return
     */
    @Override
    public Result<ReportPostVO> getReportPost(PageQueryDTO pageQueryDTO) {
      //  Page<ReportPostVO> mpPage = pageQueryDTO.toMpPage(pageQueryDTO.getSortBy(), pageQueryDTO.getSortOrder());
        Page<Reports> page1 = Page.of(pageQueryDTO.getPage(), pageQueryDTO.getSize());

        Page<ReportPostVO> page = baseMapper.getReportPost(page1,pageQueryDTO.getSort_by(),pageQueryDTO.getSort_order());
        List<ReportPostVO> records = page.getRecords();
        Result<ReportPostVO> result = new Result<>();
        result.setRecords(records);

        PageResult pagination =new PageResult();
        pagination.setPage(pageQueryDTO.getPage());
        pagination.setPageSize(pageQueryDTO.getSize());
        pagination.setTotal_pages((int)page.getPages());
        //判断是否有下一页
        pagination.setHas_next(pageQueryDTO.getPage() <(int)page.getPages());
        //判断是否有上一页
        pagination.setHas_previous(pageQueryDTO.getPage() > 1);
        pagination.setTotal_records((int)page.getTotal());
        result.setPagination(pagination);
        return result;
    }

    /**
     * 举报评论 添加
     * @param commentId
     * @param reportDTO
     */
    @Override
    public void reportComment(Integer commentId, ReportDTO reportDTO) {
        //把举报信息填充数据库
        Reports reports=new Reports();
        reports.setTargetId(commentId);
        reports.setTargetType(TargetTypeEnum.PINGLUN.getValue());
        reports.setReasonType(reportDTO.getReason_type());
        reports.setReasonContent(reportDTO.getReason_content());
        reports.setCreatedAt(LocalDateTime.now());
        reports.setUpdatedAt(LocalDateTime.now());
        reports.setStatus(ReportStatusEnum.DAICL.getValue());
        save(reports);
        //更新评论状态
        LambdaUpdateWrapper<Comments> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(Comments::getCommentId,commentId).set(Comments::getStatus, CommentsStatusEnum.HIDDEN.getStatus());
       commentsService.update(wrapper);
    }

    /**
     * 获取举报评论
     * @param pageQueryDTO
     * @return
     */
    @Override
    public Result<ReportCommentVO> getReportComment(PageQueryDTO pageQueryDTO) {
        Page<Reports> page1 = Page.of(pageQueryDTO.getPage(), pageQueryDTO.getSize());
        Page<ReportCommentVO> page = baseMapper.getReportComment(page1,pageQueryDTO.getSort_by(),pageQueryDTO.getSort_order());

        List<ReportCommentVO> records = page.getRecords();
        Result<ReportCommentVO> result = new Result<>();
        result.setRecords(records);

        PageResult pagination =new PageResult();
        pagination.setPage(pageQueryDTO.getPage());
        pagination.setPageSize(pageQueryDTO.getSize());
        pagination.setTotal_pages((int)page.getPages());
        //判断是否有下一页
        pagination.setHas_next(pageQueryDTO.getPage() <(int)page.getPages());
        //判断是否有上一页
        pagination.setHas_previous(pageQueryDTO.getPage() > 1);
        pagination.setTotal_records((int)page.getTotal());
        result.setPagination(pagination);
        return result;
    }
}
