package com.example.hr_management_task.controller;

import com.example.hr_management_task.dto.LoginDto;
import com.example.hr_management_task.security.JwtProvider;
import com.example.hr_management_task.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    final JwtProvider jwtProvider;
    final AuthService authService;
    final AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto dto) {
        String token = jwtProvider.generateToken(dto.getUsername());
        return ResponseEntity.ok().body(token);
    }
}
