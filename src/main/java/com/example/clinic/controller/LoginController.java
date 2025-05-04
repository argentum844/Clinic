package com.example.clinic.controller;

import com.example.clinic.model.dto.AuthRequest;
import com.example.clinic.model.dto.AuthResponse;
import com.example.clinic.service.LoginService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "localhost:8080/")
@RestController
@RequestMapping("/test")
@Slf4j
public class LoginController {
//    @Autowired
//    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody String request){
//        log.info();
//        log.info("Request: {}", full);
        log.info("Получили для входа: {}", request);
//        try {
//            return ResponseEntity.ok(loginService.login(request));
//        } catch (Exception e) {
//        return ResponseEntity
//                .badRequest()
//                .body(e.getMessage());
//        }
        return null;
    }

}