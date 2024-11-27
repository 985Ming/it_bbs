package com.it.bbs.service.impl;

import com.it.bbs.entity.Comments;
import com.it.bbs.mapper.CommentsMapper;
import com.it.bbs.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子评论表 服务实现类
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
