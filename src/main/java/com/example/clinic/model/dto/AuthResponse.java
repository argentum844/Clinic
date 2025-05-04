package com.example.clinic.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class AuthResponse {
    private String token;
    private String login;
    private String role;
}
