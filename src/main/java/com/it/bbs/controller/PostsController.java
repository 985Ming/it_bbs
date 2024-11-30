package com.it.bbs.controller;


import com.it.bbs.pojos.dtos.AddPostDTO;
import com.it.bbs.pojos.dtos.PostQueryDTO;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.PostDetailVO;

import com.it.bbs.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 论坛帖子表 前端控制器
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@RestController
//@RequestMapping("/post")
public class PostsController {
@Autowired
private IPostsService postsService;

    /**
     * 根据帖子id查询帖子详情
     * @param postId
     * @return
     */
    @GetMapping("/post/{post_id}")
    public PostDetailVO getPostsDetail(@PathVariable("post_id") Integer postId){
    return postsService.getPostDetail(postId);

    }

    /**
     * 添加帖子
     * @param addPostDTO
     */
    @PostMapping("/post")
    public Result addPost(@RequestBody AddPostDTO addPostDTO){
        postsService.addPost(addPostDTO);
        return Result.success("发帖成功");
    }

    /**
     * 分页查询帖子
     * @param postQueryDTO
     * @return
     */
    @GetMapping("/posts")
    public Result<PostDetailVO> page(PostQueryDTO postQueryDTO){
        return postsService.getPage(postQueryDTO);
    }

}
