package com.it.bbs.service;

import com.it.bbs.pojos.dtos.CommentDTO;
import com.it.bbs.pojos.dtos.CommentQueryDTO;
import com.it.bbs.pojos.entity.Comments;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.CommentsVO;

/**
 * <p>
 * 帖子评论表 服务类
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
public interface ICommentsService extends IService<Comments> {

    Result<CommentsVO> getpage(CommentQueryDTO commentQueryDTO);

    void addComment(CommentDTO commentsDTO);

    void likeComment(Integer commentId);
}
