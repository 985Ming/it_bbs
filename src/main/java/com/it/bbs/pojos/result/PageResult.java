package com.it.bbs.pojos.result;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.io.Serializable;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class PageResult implements Serializable {
    private Integer page;
    private Integer pageSize;
    private Integer total_records;
    private Integer total_pages;
    private Boolean has_next;
    private Boolean has_previous;



}
