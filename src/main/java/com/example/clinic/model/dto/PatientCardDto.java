package com.example.clinic.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PatientCardDto {
    private String name;
    private int age;
    private String address;
}
