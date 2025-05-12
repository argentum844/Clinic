package com.example.clinic.service;

import com.example.clinic.model.entities.PatientCard;
import com.example.clinic.repository.PatientCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientCardService {
    private final PatientCardRepository repository;

    public PatientCard save(PatientCard patientCard){
        return repository.save(patientCard);
    }
}
