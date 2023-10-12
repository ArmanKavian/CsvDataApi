package com.example.sundayassignment.usecase;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileUseCase {
    void upload(MultipartFile file);
}
