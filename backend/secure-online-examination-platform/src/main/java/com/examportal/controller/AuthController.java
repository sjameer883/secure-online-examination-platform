package com.examportal.controller;

import com.examportal.dto.AuthResponse;
import com.examportal.dto.LoginRequest;
import com.examportal.dto.RegisterRequest;
import com.examportal.service.AuthService;
import com.examportal.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService,
                          AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }


    @PostMapping("/register")
public AuthResponse register(@Valid @RequestBody RegisterRequest request) {

    System.out.println("REGISTER API CALLED");

    String message = userService.registerUser(request);

    return new AuthResponse(message);
}

    // Login User
    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }
}