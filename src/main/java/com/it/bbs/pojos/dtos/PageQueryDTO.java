package com.it.bbs.pojos.dtos;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class PageQueryDTO {
private Integer page =1;
private Integer size =6;
private String sortBy;
private String sortOrder;

    public <T> Page<T> toMpPage(String sortBy,String sortOrder){
        Page<T> page1=Page.of(page,size);
        if(StrUtil.isNotBlank(sortBy)){
            page1.addOrder(new OrderItem(sortBy, sortOrder.equals("asc")? true : false));
        }
        return page1;
    }




}
