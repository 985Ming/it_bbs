package com.it.bbs.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.it.bbs.enums.TargetTypeEnum;
import com.it.bbs.pojos.entity.Likes;
import com.it.bbs.mapper.LikesMapper;
import com.it.bbs.pojos.entity.Posts;
import com.it.bbs.service.ILikesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.bbs.service.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * 点赞记录表 服务实现类
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@Service
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements ILikesService {

    @Autowired
    private IPostsService postsService;
    /**
     * 点赞帖子
     * @param postId
     */
    @Override
    @Transactional
    public void addLikePost(Integer postId) {
        //新增点赞
        Likes likes=new Likes();
        likes.setTargetId(postId);
        likes.setTargetType(TargetTypeEnum.TIEZI.getValue());
        likes.setCreatedAt(LocalDateTime.now());
        //todo
        likes.setDeviceId(System.currentTimeMillis()+"");
        save(likes);
        //查询当前点赞数
        Posts byId = postsService.getById(postId);

        //更新帖子点赞数
        LambdaUpdateWrapper<Posts> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(Posts::getPostId,postId);
        wrapper.set(Posts::getLikes,byId.getLikes()+1);
        postsService.update(wrapper);
    }
}
