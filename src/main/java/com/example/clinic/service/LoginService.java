package com.example.clinic.service;

import com.example.clinic.model.dto.AuthRequest;
import com.example.clinic.model.dto.AuthResponse;
import com.example.clinic.model.entities.User;
import com.example.clinic.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    PasswordEncoder passwordEncoder;


    public AuthResponse login(AuthRequest request) throws Exception {
        if (verifyUser(request)) {
            log.info("Пользователь найден");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getLogin(),
                            request.getPassword()
                    )
            );

            User user = userRepository.findByLogin(request.getLogin()).get();
            String token = jwtService.generateToken(user.getLogin(), user.getRole());
            return new AuthResponse(token, user.getLogin(), user.getRole());
        }
        throw new Exception("Некорректный логин или пароль!");
    }

    private boolean verifyUser(AuthRequest request){
        Optional<User> user = userRepository.findByLogin(request.getLogin());

        if (user.isPresent()){
            log.info("Извлекли из базы: " + user.get().toString());
            String pass = passwordEncoder.encode(request.getPassword());
            return user.get().getPassword() == pass;
        }
        return false;
    }
}
