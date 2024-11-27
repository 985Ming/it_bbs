package com.it.bbs.service.impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.bbs.enums.PostsStatusEnum;
import com.it.bbs.mapper.PostsMapper;
import com.it.bbs.pojos.dtos.AddPostDTO;
import com.it.bbs.pojos.dtos.PostQueryDTO;
import com.it.bbs.pojos.entity.Avatars;
import com.it.bbs.pojos.entity.Posts;
import com.it.bbs.pojos.result.PageResult;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.AvatarsVO;
import com.it.bbs.pojos.vos.PostDetailVO;
import com.it.bbs.service.IAvatarsService;
import com.it.bbs.service.IPostsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 论坛帖子表 服务实现类
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements IPostsService {

    @Autowired
    private IAvatarsService avatarsService;

    /**
     * 查询帖子详情
     * @param postId
     * @return
     */
    @Override
    public PostDetailVO getPostDetail(Integer postId) {
        Posts posts = baseMapper.selectById(postId);
        Avatars avatars = avatarsService.getById(posts.getAvatarId());
      PostDetailVO postDetailVO = new PostDetailVO();
        BeanUtils.copyProperties(posts, postDetailVO);
        postDetailVO.setImageUrl(avatars.getImageUrl());
     return postDetailVO;
    }

    /**
     * 添加帖子
     * @param addPostDTO
     */
    @Override
    public void addPost(AddPostDTO addPostDTO) {
        Posts posts =  Posts.builder()
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .status(PostsStatusEnum.NORMAL.getStatus())
                .likes(0)
                .views(0)
                .build();

        BeanUtils.copyProperties(addPostDTO,posts);
        save(posts);
    }
    /**
     * 分页查询帖子
     * @param postQueryDTO
     * @return
     */
    @Override
    public Result<PostDetailVO> getPage(PostQueryDTO postQueryDTO) {
        Page<Posts> mpPage = postQueryDTO.toMpPage(postQueryDTO.getSortBy(), postQueryDTO.getSortOrder());

        Page<Posts> page = lambdaQuery().eq(ObjectUtil.isNotEmpty(postQueryDTO.getStatus()), Posts::getStatus, postQueryDTO.getStatus())
                .in(Posts::getStatus,PostsStatusEnum.NORMAL.getStatus(),PostsStatusEnum.TOP.getStatus())
                .orderByDesc(Posts::getStatus)
                .page(mpPage);
        PageResult pagination =new PageResult();
        pagination.setPage(postQueryDTO.getPage());
        pagination.setPageSize(postQueryDTO.getSize());
        pagination.setTotal_pages((int)page.getPages());
        //判断是否有下一页
        pagination.setHas_next(postQueryDTO.getPage() <(int)page.getPages());
        //判断是否有上一页
        pagination.setHas_previous(postQueryDTO.getPage() > 1);
        pagination.setTotal_records((int)page.getTotal());

        List<Posts> records = page.getRecords();
        List<PostDetailVO> collect = records.stream().map(post -> {
            PostDetailVO vo = BeanUtil.copyProperties(post, PostDetailVO.class);
            // 设置 image 字段（这里可以是动态获取）
            vo.setImageUrl(avatarsService.getById(post.getAvatarId()).getImageUrl()); // 假设通过 postId 获取 image
            return vo;
        }).collect(Collectors.toList());
        Result<PostDetailVO> result = new Result<>();
        result.setRecords(collect);
        result.setPagination(pagination);
        return result;
    }


}
