package com.example.clinic.controller;


import com.example.clinic.model.dto.JwtAuthenticationResponse;
import com.example.clinic.model.dto.SigninDto;
import com.example.clinic.model.dto.SignupDto;
import com.example.clinic.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Аутентификация")
public class AuthController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Регистрация пользователя")
    @PostMapping("/signup")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignupDto request) {
        return authenticationService.signUp(request);
    }

    @Operation(summary = "Авторизация пользователя")
    @PostMapping("/signin")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SigninDto request) {
        return authenticationService.signIn(request);
    }
}