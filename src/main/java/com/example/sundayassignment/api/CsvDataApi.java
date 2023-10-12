package com.example.sundayassignment.api;

import com.example.sundayassignment.dto.CsvDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CsvDataApi {
    @PostMapping("/api/csv-data/upload")
    ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file);

    @GetMapping("/api/csv-data/fetch-all")
    ResponseEntity<List<CsvDataDto>> fetchAllData();

    @GetMapping("/api/csv-data/fetch-by-code/{code}")
    ResponseEntity<CsvDataDto> fetchByCode(@PathVariable String code);

    @DeleteMapping("/api/csv-data/delete-all")
    ResponseEntity<Object> deleteAllData();
}
