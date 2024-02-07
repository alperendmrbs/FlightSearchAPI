package com.project.flightsearchapi.service;

import com.project.flightsearchapi.dto.JwtAuthResponse;
import com.project.flightsearchapi.dto.SignInRequest;
import com.project.flightsearchapi.dto.SignUpRequest;
import com.project.flightsearchapi.models.User;
import com.project.flightsearchapi.models.Role;
import com.project.flightsearchapi.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public JwtAuthResponse auth(SignInRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }

    public JwtAuthResponse signup(SignUpRequest request) {
        var user = User.builder().email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userService.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(jwt).build();
    }
}
