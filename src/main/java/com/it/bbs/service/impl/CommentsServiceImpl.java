package com.it.bbs.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.bbs.enums.CommentsStatusEnum;
import com.it.bbs.enums.PostsStatusEnum;
import com.it.bbs.enums.ReportStatusEnum;
import com.it.bbs.pojos.dtos.CommentDTO;
import com.it.bbs.pojos.dtos.CommentQueryDTO;
import com.it.bbs.pojos.entity.Comments;
import com.it.bbs.mapper.CommentsMapper;
import com.it.bbs.pojos.entity.Posts;
import com.it.bbs.pojos.entity.Reports;
import com.it.bbs.pojos.result.PageResult;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.CommentsVO;
import com.it.bbs.pojos.vos.PostDetailVO;
import com.it.bbs.pojos.vos.ReportPostVO;
import com.it.bbs.service.IAvatarsService;
import com.it.bbs.service.ICommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private IAvatarsService avatarsService;

    /**
     * 分页查询评论
     * @param commentQueryDTO
     * @return
     */
    @Override
    public Result<CommentsVO> getpage(CommentQueryDTO commentQueryDTO) {
        Page<Comments> mpPage = commentQueryDTO.toMpPage(commentQueryDTO.getSort_by(), commentQueryDTO.getSort_order());
        LambdaQueryWrapper<Comments> queryWrapper =null;
        if(commentQueryDTO.getParent_id()==null){
            queryWrapper  = Wrappers.<Comments> lambdaQuery().eq(ObjectUtils.isNotNull(commentQueryDTO.getPost_id()),Comments::getPostId ,commentQueryDTO.getPost_id())
                .eq(ObjectUtils.isNotNull(commentQueryDTO.getParent_id()),Comments::getParentId ,commentQueryDTO.getParent_id())
                .in(Comments::getStatus,CommentsStatusEnum.NORMAL.getStatus())
                .isNull(Comments::getParentId);}else{
           queryWrapper = Wrappers.<Comments> lambdaQuery().eq(ObjectUtils.isNotNull(commentQueryDTO.getPost_id()),Comments::getPostId ,commentQueryDTO.getPost_id())
                    .eq(ObjectUtils.isNotNull(commentQueryDTO.getParent_id()),Comments::getParentId ,commentQueryDTO.getParent_id())
                    .in(Comments::getStatus,CommentsStatusEnum.NORMAL.getStatus())
                    .isNotNull(Comments::getParentId);
        }

        Page<Comments> page = baseMapper.selectPage(mpPage, queryWrapper);

        PageResult pagination =new PageResult();
        pagination.setPage(commentQueryDTO.getPage());

        pagination.setPageSize(commentQueryDTO.getSize());
        pagination.setTotal_pages((int)page.getPages());
        //判断是否有下一页
        pagination.setHas_next(commentQueryDTO.getPage() <(int)page.getPages());
        //判断是否有上一页
        pagination.setHas_previous(commentQueryDTO.getPage() > 1);
        pagination.setTotal_records((int)page.getTotal());

        List<Comments> records = page.getRecords();
        List<CommentsVO> commentsVOS = BeanUtil.copyToList(records, CommentsVO.class);
        List<CommentsVO> collect = commentsVOS.stream().map(post -> {
            // 设置 image 字段（这里可以是动态获取）
            post.setImageUrl(avatarsService.getById(post.getAvatarId()).getImageUrl()); // 假设通过 postId 获取 image
            return post;
        }).collect(Collectors.toList());
        Result<CommentsVO> result = new Result<>();
        result.setRecords(collect);
        result.setPagination(pagination);
        return result;
    }

    /**
     * 发布评论
     * @param commentsDTO
     */
    @Override
    @Transactional
    public void addComment(CommentDTO commentsDTO) {

            Comments comments = BeanUtil.copyProperties(commentsDTO, Comments.class);
            comments.setCreatedAt(LocalDateTime.now());
            comments.setLikes(0);
            comments.setStatus(CommentsStatusEnum.NORMAL.getStatus());
        comments.setReplyCount(0);
        save(comments);
        if(commentsDTO.getParentId()!=null) {
            Comments comments1 = baseMapper.selectById(commentsDTO.getParentId());
            comments1.setReplyCount(comments1.getReplyCount()+1);
            baseMapper.updateById(comments1);
        }



    }
    /**
     * 点赞评论
     * @param commentId
     */
    @Override
    public void likeComment(Integer commentId) {

        lambdaUpdate().setSql("likes = likes + 1").eq(Comments::getCommentId,commentId).update();
    }
}
