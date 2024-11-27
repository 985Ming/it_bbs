package com.it.bbs.controller;


import com.it.bbs.pojos.dtos.ReportDTO;
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
    @Autowired
    private IReportsService reportsService;
@PutMapping("/post/{post_id}")
    public void reportPost(@PathVariable("post_id")  Integer postId, @RequestBody ReportDTO reportDTO){
         reportsService.reportPost(postId,reportDTO);

    }
}
