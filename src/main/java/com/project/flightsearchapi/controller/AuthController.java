package com.project.flightsearchapi.controller;

import com.project.flightsearchapi.dto.JwtAuthResponse;
import com.project.flightsearchapi.dto.SignInRequest;
import com.project.flightsearchapi.dto.SignUpRequest;
import com.project.flightsearchapi.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    public JwtAuthResponse token(@RequestBody SignInRequest request){
        return authService.auth(request);

    }

    @PostMapping("/signup")
    public JwtAuthResponse signup(@RequestBody SignUpRequest request){
        return authService.signup(request);
    }
}
