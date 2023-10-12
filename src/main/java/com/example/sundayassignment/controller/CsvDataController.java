package com.example.sundayassignment.resource;

import com.example.sundayassignment.domain.CsvData;
import com.example.sundayassignment.domain.repository.CsvDataRepository;
import com.example.sundayassignment.usecase.DeleteDataUseCase;
import com.example.sundayassignment.usecase.FetchDataUseCase;
import com.example.sundayassignment.usecase.UploadFileUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import static org.springframework.http.ResponseEntity.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/csv-data")
public final class CsvDataController {
    private final UploadFileUseCase uploadFileUseCase;
    private final FetchDataUseCase fetchDataUseCase;
    private final DeleteDataUseCase deleteDataUseCase;

    @Autowired
    public CsvDataController(UploadFileUseCase uploadFileUseCase,
                             FetchDataUseCase fetchDataUseCase,
                             DeleteDataUseCase deleteDataUseCase) {
        this.uploadFileUseCase = uploadFileUseCase;
        this.fetchDataUseCase = fetchDataUseCase;
        this.deleteDataUseCase = deleteDataUseCase;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            uploadFileUseCase.upload(file);
        } catch (RuntimeException ex) {
            return ResponseEntity.ok("File upload failed");
        }

        return ok("File uploaded successfully");
    }

    @GetMapping("/fetch-all")
    public ResponseEntity<Iterable<CsvData>> fetchAllData() {
        try {
            return ok(fetchDataUseCase.fetchAllData());
        } catch (RuntimeException ex) {
            return internalServerError().build();
        }
    }

    @GetMapping("/fetch-by-code/{code}")
    public ResponseEntity<CsvData> fetchByCode(@PathVariable String code) {
        try {
            return ok(fetchDataUseCase.fetchByCode(code));
        } catch (RuntimeException ex) {
            return badRequest().build();
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Object> deleteAllData() {
        try {
            deleteDataUseCase.deleteAllData();
            return noContent().build();
        } catch (RuntimeException ex) {
            return badRequest().build();
        }
    }
}
