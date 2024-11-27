package com.it.bbs.service.impl;

import com.it.bbs.entity.Posts;
import com.it.bbs.mapper.PostsMapper;
import com.it.bbs.service.IPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
