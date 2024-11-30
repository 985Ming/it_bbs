package com.it.bbs.controller;


import com.it.bbs.pojos.dtos.PageQueryDTO;
import com.it.bbs.pojos.dtos.ReportDTO;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.ReportCommentVO;
import com.it.bbs.pojos.vos.ReportPostVO;
import com.it.bbs.service.IReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 内容举报表 前端控制器
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@RestController
@RequestMapping("/report")
public class ReportsController {
    /**
     * 举报帖子
     */
    @Autowired
    private IReportsService reportsService;
@PutMapping("/post/{post_id}")
    public void reportPost(@PathVariable("post_id")  Integer postId, @RequestBody ReportDTO reportDTO){
         reportsService.reportPost(postId,reportDTO);

    }
    //查询举报帖子
    @GetMapping("/post")
    public Result<ReportPostVO> getReportPost(PageQueryDTO pageQueryDTO){
        return reportsService.getReportPost(pageQueryDTO);
    }

    /**
     * 举报评论
     * @param commentId
     * @param reportDTO
     */
    @PutMapping("/comment/{comment_id}")
    public Result reportComment(@PathVariable("comment_id") Integer commentId,@RequestBody ReportDTO reportDTO){
        reportsService.reportComment(commentId,reportDTO);
        return Result.success("举报成功");
    }
    //查询举报评论
    @GetMapping("/comment")
    public Result<ReportCommentVO> getReportComment(PageQueryDTO pageQueryDTO){
        return reportsService.getReportComment(pageQueryDTO);
    }

}
