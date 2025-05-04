package com.example.clinic.controller;

import com.example.clinic.model.dto.RegisterDto;
import com.example.clinic.model.entities.User;
import com.example.clinic.service.RegisterService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "localhost:8080/")
@RestController
@RequestMapping("/register")
@Slf4j
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDto registerDto) {
        try {
            log.info("На регистрацию пришло: " + registerDto);
            User user = registerService.registerUser(registerDto);
            return ResponseEntity.ok("User registered successfully!");
        } catch (RuntimeException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
