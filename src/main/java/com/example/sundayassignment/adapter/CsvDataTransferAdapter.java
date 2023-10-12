package com.example.sundayassignment.adapter;

import com.example.sundayassignment.dto.CsvDataDto;
import com.example.sundayassignment.domain.CsvData;
import org.springframework.stereotype.Component;

@Component
public class CsvDataTransferAdapter {

    public CsvDataDto toDto(CsvData entity) {
        return new CsvDataDto().source(entity.source())
                .codeListCode(entity.codeListCode())
                .code(entity.code())
                .displayValue(entity.displayValue())
                .longDescription(entity.longDescription())
                .fromDate(entity.fromDate())
                .toDate(entity.toDate())
                .sortPriority(entity.sortPriority());
    }
}
