package com.example.sundayassignment.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;


@Entity
@Table(name = "csv_data_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true, fluent = true)
public class CsvData {

    @Id
    @GeneratedValue
    @Column(name = "csv_data_id")
    private Long id;

    private String source;

    private String codeListCode;

    @Column(unique=true)
    private String code;

    private String displayValue;

    private String longDescription;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Integer sortPriority;
}
