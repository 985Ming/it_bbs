package com.it.bbs.service.impl;

import com.it.bbs.entity.Likes;
import com.it.bbs.mapper.LikesMapper;
import com.it.bbs.service.ILikesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
