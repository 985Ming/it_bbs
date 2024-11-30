package com.it.bbs.pojos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class PostQueryDTO extends PageQueryDTO implements Serializable {
    private Integer status;
}
