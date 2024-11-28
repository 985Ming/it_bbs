package com.it.bbs.controller;


import com.it.bbs.pojos.dtos.CommentDTO;
import com.it.bbs.pojos.dtos.CommentQueryDTO;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.CommentsVO;
import com.it.bbs.service.ICommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 帖子评论表 前端控制器
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@RestController
@RequestMapping("/comment")
public class CommentsController {
@Autowired
private ICommentsService commentsService;

    /**
     * 分页查询评论
     * @param commentQueryDTO
     * @return
     */
    @GetMapping
    public Result<CommentsVO> getComments(CommentQueryDTO commentQueryDTO){
return  commentsService.getpage(commentQueryDTO);
    }
    /**
     * 添加评论
     * @param commentsDTO
     */

    @PostMapping
    public void addComment( @RequestBody CommentDTO commentsDTO){
        commentsService.addComment(commentsDTO);
    }

    /**
     * 点赞评论
     * @param commentId
     */
    @PutMapping("/like/{comment_id}")
    public void likeComment(@PathVariable("comment_id") Integer commentId){
        commentsService.likeComment(commentId);
    }
}
