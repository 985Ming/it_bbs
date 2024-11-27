package com.it.bbs.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.SelectPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.bbs.pojos.dtos.PageQueryDTO;
import com.it.bbs.pojos.entity.Avatars;
import com.it.bbs.mapper.AvatarsMapper;
import com.it.bbs.pojos.result.PageResult;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.AvatarsVO;
import com.it.bbs.service.IAvatarsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank;

/**
 * <p>
 * 预设头像表 服务实现类
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@Service
public class AvatarsServiceImpl extends ServiceImpl<AvatarsMapper, Avatars> implements IAvatarsService {

    @Override
    public Result<AvatarsVO> getAvatars(PageQueryDTO pageQueryDTO) {
//        List<AvatarsVO> collect=new ArrayList<>();
//        PageResult pagination = new PageResult();
//        pagination.setTotal_pages(0);
//        pagination.setTotal_records(0);
//        pagination.setPage(0);
//        pagination.setPageSize(0);
//        pagination.setHas_next(true);
//        pagination.setHas_previous(true);
 //       if(pageQueryDTO.getPage() != null) {
            Page<Avatars> page = pageQueryDTO.toMpPage(pageQueryDTO.getSortBy(), pageQueryDTO.getSortOrder());
            // 查询所有数据
            Page<Avatars> list = page(page);
            List<Avatars> records = list.getRecords();
        List<AvatarsVO>   collect = BeanUtil.copyToList(records, AvatarsVO.class);
            //   List<AvatarsVO> collect = records.stream().map(avatars -> new AvatarsVO(avatars.getAvatarId(), avatars.getImageUrl())).collect(Collectors.toList());
            //分页参数
        PageResult    pagination = new PageResult();
            pagination.setPage(pageQueryDTO.getPage());// 当前页码
            pagination.setPageSize(pageQueryDTO.getSize());// 每页显示条数
            // 总记录数
            pagination.setTotal_records((int) list.getTotal());
            // 总页数
            long pages = list.getPages();
            pagination.setTotal_pages((int) pages);
            //判断是否有下一页
            pagination.setHas_next(pageQueryDTO.getPage() < pages);
            //判断是否有上一页
            pagination.setHas_previous(pageQueryDTO.getPage() > 1);
//        }else {
//            LambdaQueryWrapper<Avatars> wrapper=new LambdaQueryWrapper<Avatars>();
//
//            List<Avatars> list = list(wrapper);
//             collect = BeanUtil.copyToList(list, AvatarsVO.class);
//        }
        Result<AvatarsVO> result = new Result<>();
        result.setRecords(collect);
        result.setPagination(pagination);
        return result;
    }
}
