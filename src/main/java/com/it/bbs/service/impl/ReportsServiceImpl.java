package com.it.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.it.bbs.enums.PostsStatusEnum;
import com.it.bbs.enums.ReasonTypeEnum;
import com.it.bbs.enums.ReportStatusEnum;
import com.it.bbs.enums.TargetTypeEnum;
import com.it.bbs.pojos.dtos.ReportDTO;
import com.it.bbs.pojos.entity.Posts;
import com.it.bbs.pojos.entity.Reports;
import com.it.bbs.mapper.ReportsMapper;
import com.it.bbs.service.IPostsService;
import com.it.bbs.service.IReportsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
}
