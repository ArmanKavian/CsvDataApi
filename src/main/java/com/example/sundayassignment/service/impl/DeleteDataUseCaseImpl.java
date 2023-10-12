package com.example.sundayassignment.service.impl;

import com.example.sundayassignment.repository.CsvDataRepository;
import com.example.sundayassignment.service.DeleteDataUseCase;
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
