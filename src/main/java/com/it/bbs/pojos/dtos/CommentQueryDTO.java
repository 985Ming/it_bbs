package com.it.bbs.pojos.dtos;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class CommentQueryDTO extends PageQueryDTO {
    private Integer post_id;
    private Integer parent_id;
}
