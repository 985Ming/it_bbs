package com.it.bbs.pojos.result;

import lombok.Data;

import java.util.List;

@Data
public class Result<T> {
private List<T> records;
private PageResult pagination;

}
