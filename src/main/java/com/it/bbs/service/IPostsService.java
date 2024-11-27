package com.it.bbs.service;

import com.it.bbs.pojos.dtos.AddPostDTO;
import com.it.bbs.pojos.dtos.PostQueryDTO;
import com.it.bbs.pojos.entity.Posts;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.PostDetailVO;

/**
 * <p>
 * 论坛帖子表 服务类
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
public interface IPostsService extends IService<Posts> {

    PostDetailVO getPostDetail(Integer postId);

    void addPost(AddPostDTO addPostDTO);


    Result<PostDetailVO> getPage(PostQueryDTO postQueryDTO);
}
