package com.example.clinic.service;

import com.example.clinic.model.dto.JwtAuthenticationResponse;
import com.example.clinic.model.dto.SigninDto;
import com.example.clinic.model.dto.SignupDto;
import com.example.clinic.model.entities.PatientCard;
import com.example.clinic.model.entities.User;
import com.example.clinic.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final PatientCardService patientCardService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    public JwtAuthenticationResponse signUp(SignupDto request) {

        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        PatientCard patientCard = new PatientCard();
        patientCard.setName(request.getName());
        patientCard.setAge(request.getAge());
        patientCard.setAddress(request.getAddress());
        patientCard.setUser(user);
        user.setCard(patientCard);

        userService.create(user);
        patientCardService.save(patientCard);

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }


    public JwtAuthenticationResponse signIn(SigninDto request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));

        var user = userService
                .userDetailsService()
                .loadUserByUsername(request.getUsername());

        var jwt = jwtService.generateToken(user);
        return new JwtAuthenticationResponse(jwt);
    }
}
