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
@RequestMapping("/reg")
@Slf4j
public class SthController {
//    @Autowired
//    RegisterService registerService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody String registerDto) {
        log.info("На вход пришло: " + registerDto);

        return null;
    }
}
