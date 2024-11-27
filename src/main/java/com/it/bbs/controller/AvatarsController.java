package com.it.bbs.controller;


import com.it.bbs.pojos.dtos.PageQueryDTO;
import com.it.bbs.pojos.result.Result;
import com.it.bbs.pojos.vos.AvatarsVO;
import com.it.bbs.service.IAvatarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 预设头像表 前端控制器
 * </p>
 *
 * @author yym
 * @since 2024-11-27
 */
@RestController
@RequestMapping("/avatar")
public class AvatarsController {

    @Autowired
    private IAvatarsService avatarsService;

    @GetMapping
    public Result<AvatarsVO> getAvatars(PageQueryDTO pageQueryDTO){
      return   avatarsService.getAvatars(pageQueryDTO);
    }

}
