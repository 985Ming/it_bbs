package com.it.bbs.pojos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ReportDTO {
private String reason_content;
private Integer reason_type;
}
