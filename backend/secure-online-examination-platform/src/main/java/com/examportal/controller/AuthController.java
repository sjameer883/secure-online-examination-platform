package com.examportal.controller;

import com.examportal.dto.AuthResponse;
import com.examportal.dto.RegisterRequest;
import com.examportal.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public AuthResponse register(
            @RequestBody RegisterRequest request) {

        String message =
                userService.registerUser(request);

        return new AuthResponse(message);
    }
}