package com.example.clinic.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UserTable",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "login")
    }
)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @NotBlank
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private PatientCard card;
}
