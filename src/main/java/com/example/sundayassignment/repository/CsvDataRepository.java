package com.example.sundayassignment.repository;

import com.example.sundayassignment.domain.CsvData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvDataRepository extends CrudRepository<CsvData, Long> {
    CsvData findByCode(String code);
}
