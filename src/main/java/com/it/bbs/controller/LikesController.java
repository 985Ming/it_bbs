package com.it.bbs.controller;


import com.it.bbs.service.ILikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 点赞记录表 前端控制器
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@RestController
//@RequestMapping("/like")
public class LikesController {
   @Autowired
   private ILikesService likesService;
    /**
     * 点赞
     * @param postId
     */
    @PutMapping("/post/like/{post_id}")
    public void likePost(@PathVariable("post_id") Integer postId){
        likesService.addLikePost(postId);

    }
}
