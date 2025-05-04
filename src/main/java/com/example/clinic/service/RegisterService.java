package com.example.clinic.service;

import com.example.clinic.model.dto.RegisterDto;
import com.example.clinic.model.entities.PatientCard;
import com.example.clinic.model.entities.User;
import com.example.clinic.repository.PatientCardRepository;
import com.example.clinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PatientCardRepository patientCardRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerUser(RegisterDto registerDto) {
        if (userRepository.existsByLogin(registerDto.getLogin())) {
            throw new RuntimeException("Username is already taken!");
        }

        User user = new User();
        user.setLogin(registerDto.getLogin());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole("USER");

        PatientCard card = new PatientCard();
        card.setAddress(registerDto.getAddress());
        card.setAge(registerDto.getAge());
        card.setName(registerDto.getName());
        card.setUser(user);
        user.setCard(card);

        patientCardRepository.save(card);
        return userRepository.save(user);
    }
}
