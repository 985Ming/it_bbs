package com.it.bbs.service;

import com.it.bbs.pojos.dtos.PageQueryDTO;
import com.it.bbs.pojos.entity.Avatars;
import com.baomidou.mybatisplus.extension.service.IService;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.AvatarsVO;

/**
 * <p>
 * 预设头像表 服务类
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
public interface IAvatarsService extends IService<Avatars> {

    Result<AvatarsVO> getAvatars(PageQueryDTO pageQueryDTO);
}
