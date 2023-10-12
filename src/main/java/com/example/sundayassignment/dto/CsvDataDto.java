package com.example.sundayassignment.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true, fluent = true)
public class CsvDataDto {

    private String source;

    private String codeListCode;

    private String code;

    private String displayValue;

    private String longDescription;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Integer sortPriority;
}
