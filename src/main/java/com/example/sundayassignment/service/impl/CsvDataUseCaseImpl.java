package com.example.sundayassignment.usecase.impl;

import com.example.sundayassignment.domain.CsvData;
import com.example.sundayassignment.domain.repository.CsvDataRepository;
import com.example.sundayassignment.usecase.UploadFileUseCase;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvDataUseCaseImpl implements UploadFileUseCase {

    private final CsvDataRepository csvDataRepository;

    @Autowired
    public CsvDataUseCaseImpl(CsvDataRepository csvDataRepository) {
        this.csvDataRepository = csvDataRepository;
    }

    @Override
    public void upload(MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("File is empty");
        }

        final List<CsvData> newItems = new ArrayList<>();

        try {
            java.util.List<String[]> csvData = readCSV(file);

            for (int rowNumber = 1; rowNumber < csvData.size(); ++rowNumber) {
                final String[] row = csvData.get(rowNumber);

                CsvData item = new CsvData()
                        .source(row[0])
                        .codeListCode(row[1])
                        .code(row[2])
                        .displayValue(row[3])
                        .longDescription(row[4])
                        .fromDate(LocalDate.now())
                        .toDate(LocalDate.now())
                        .sortPriority(Integer.parseInt(row[7]));

                newItems.add(item);
            }

            csvDataRepository.saveAll(newItems);

        } catch (IOException | CsvException ex) {
            ex.printStackTrace();
            throw new RuntimeException("File upload failed.", ex);
        }
    }

    private List<String[]> readCSV(MultipartFile file) throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            return csvReader.readAll();
        }
    }
}
