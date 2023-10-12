package com.example.sundayassignment.usecase;

import com.example.sundayassignment.domain.CsvData;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FetchDataUseCase {
    Iterable<CsvData> fetchAllData();

    CsvData fetchByCode(String code);
}
