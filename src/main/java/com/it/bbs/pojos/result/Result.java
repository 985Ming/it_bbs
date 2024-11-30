package com.it.bbs.pojos.result;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Result<T> implements Serializable {
private List<T> records;
private PageResult pagination;





    private String detail; //错误信息




    public static  Result success(String detail) {
        Result result = new Result();
        result.detail=detail;
        return result;
    }

}
