package com.example.sundayassignment.usecase.impl;

import com.example.sundayassignment.domain.CsvData;
import com.example.sundayassignment.domain.repository.CsvDataRepository;
import com.example.sundayassignment.usecase.DeleteDataUseCase;
import com.example.sundayassignment.usecase.FetchDataUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteDataUseCaseImpl implements DeleteDataUseCase {

    private final CsvDataRepository csvDataRepository;

    @Autowired
    public DeleteDataUseCaseImpl(CsvDataRepository csvDataRepository) {
        this.csvDataRepository = csvDataRepository;
    }


    @Override
    public void deleteAllData() {
        csvDataRepository.deleteAll();
    }
}
