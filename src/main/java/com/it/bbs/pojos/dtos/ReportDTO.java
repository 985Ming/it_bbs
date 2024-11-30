package com.it.bbs.pojos.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor

public class ReportDTO implements Serializable {
private String reason_content;
private Integer reason_type;
}
