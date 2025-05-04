package com.example.clinic.repository;

import com.example.clinic.model.entities.PatientCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientCardRepository extends JpaRepository<PatientCard, Long> {
}
