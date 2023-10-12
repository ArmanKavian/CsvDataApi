package com.example.sundayassignment.service;

import com.example.sundayassignment.domain.CsvData;

public interface FetchDataUseCase {
    Iterable<CsvData> fetchAllData();

    CsvData fetchByCode(String code);
}
