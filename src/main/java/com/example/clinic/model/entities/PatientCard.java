package com.example.clinic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "PatientCard")
@Getter
@Setter
public class PatientCard {
    @Id
    private Long patientId;

    @NotBlank
    private String name;
    private int age;
    private String address;

    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments;

}
