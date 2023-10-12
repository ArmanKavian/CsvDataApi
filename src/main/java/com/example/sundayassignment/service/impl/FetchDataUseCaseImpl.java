package com.example.sundayassignment.usecase.impl;

import com.example.sundayassignment.domain.CsvData;
import com.example.sundayassignment.domain.repository.CsvDataRepository;
import com.example.sundayassignment.usecase.FetchDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchDataUseCaseImpl implements FetchDataUseCase {
    private final CsvDataRepository csvDataRepository;

    @Autowired
    public FetchDataUseCaseImpl(CsvDataRepository csvDataRepository) {
        this.csvDataRepository = csvDataRepository;
    }

    @Override
    public Iterable<CsvData> fetchAllData() {
        return csvDataRepository.findAll();
    }

    @Override
    public CsvData fetchByCode(String code) {
        return csvDataRepository.findByCode(code);
    }
}
