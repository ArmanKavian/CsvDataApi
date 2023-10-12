package com.example.sundayassignment.controller;

import com.example.sundayassignment.adapter.CsvDataTransferAdapter;
import com.example.sundayassignment.dto.CsvDataDto;
import com.example.sundayassignment.service.DeleteDataUseCase;
import com.example.sundayassignment.service.FetchDataUseCase;
import com.example.sundayassignment.service.UploadFileUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@RestController
@CrossOrigin("http://localhost:4200")
public final class CsvDataController implements com.example.sundayassignment.api.CsvDataApi {
    private final UploadFileUseCase uploadFileUseCase;
    private final FetchDataUseCase fetchDataUseCase;
    private final DeleteDataUseCase deleteDataUseCase;
    private final CsvDataTransferAdapter csvDataTransferAdapter;

    @Autowired
    public CsvDataController(UploadFileUseCase uploadFileUseCase,
                             FetchDataUseCase fetchDataUseCase,
                             DeleteDataUseCase deleteDataUseCase,
                             CsvDataTransferAdapter csvDataTransferAdapter) {
        this.uploadFileUseCase = uploadFileUseCase;
        this.fetchDataUseCase = fetchDataUseCase;
        this.deleteDataUseCase = deleteDataUseCase;
        this.csvDataTransferAdapter = csvDataTransferAdapter;
    }

    @Override
    public ResponseEntity<String> uploadFile(MultipartFile file) {
        try {
            uploadFileUseCase.upload(file);
        } catch (RuntimeException ex) {
            return ResponseEntity.ok("File upload failed");
        }

        return ok("File uploaded successfully");
    }

    @Override
    public ResponseEntity<List<CsvDataDto>> fetchAllData() {
        try {
            final var allCsvData = fetchDataUseCase.fetchAllData();
            final List<CsvDataDto>  allCsvDataDto = new ArrayList<>();
            allCsvData.forEach(e -> allCsvDataDto.add(
                    csvDataTransferAdapter.toDto(e)
            ));
            return ok(allCsvDataDto);
        } catch (RuntimeException ex) {
            return internalServerError().build();
        }
    }

    @Override
    public ResponseEntity<CsvDataDto> fetchByCode(String code) {
        try {
            final var csvData = fetchDataUseCase.fetchByCode(code);
            return ok(csvDataTransferAdapter
                    .toDto(csvData)
            );
        } catch (RuntimeException ex) {
            return badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Object> deleteAllData() {
        try {
            deleteDataUseCase.deleteAllData();
            return noContent().build();
        } catch (RuntimeException ex) {
            return badRequest().build();
        }
    }
}
