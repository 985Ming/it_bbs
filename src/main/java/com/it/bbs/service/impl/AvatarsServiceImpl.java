package com.it.bbs.service.impl;

import com.it.bbs.entity.Avatars;
import com.it.bbs.mapper.AvatarsMapper;
import com.it.bbs.service.IAvatarsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
