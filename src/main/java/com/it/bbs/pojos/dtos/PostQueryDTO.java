package com.it.bbs.pojos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostQueryDTO extends PageQueryDTO{
    private Integer status;
}
