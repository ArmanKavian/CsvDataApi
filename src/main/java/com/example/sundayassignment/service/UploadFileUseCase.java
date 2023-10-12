package com.example.sundayassignment.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileUseCase {
    void upload(MultipartFile file);
}
