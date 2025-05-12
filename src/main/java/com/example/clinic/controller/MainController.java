package com.example.clinic.controller;

import com.example.clinic.model.dto.PatientCardDto;
import com.example.clinic.model.entities.User;
import com.example.clinic.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Tag(name = "Основная страница")
@Slf4j
public class MainController {
    @Autowired
    UserService userService;


    @Operation(summary = "Доступная для всех страница")
    @GetMapping
    public String getPage(){
        return "Успешно получен доступ к странице!";
    }

    @Operation(summary = "Доступная для залогиненных страница")
    @GetMapping("/user")
    public PatientCardDto getUserPage(){
        log.info("Запрос попал в контроллер (авторизация прошла успешно)");
        User user = userService.getCurrentUser();
        PatientCardDto dto = new PatientCardDto(user.getCard().getName(), user.getCard().getAge(), user.getCard().getAddress());
        return dto;
    }

}
