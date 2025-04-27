package com.example.LearningRabbitMq.controller;

import com.example.LearningRabbitMq.dto.AuthRequest;
import com.example.LearningRabbitMq.entity.TokenBlacklist;
import com.example.LearningRabbitMq.entity.User;
import com.example.LearningRabbitMq.repository.TokenBlacklistRepository;
import com.example.LearningRabbitMq.repository.UserRepository;
import com.example.LearningRabbitMq.service.AuthService;
import com.example.LearningRabbitMq.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    private JwtUtil jwtUtil;
    private UserRepository userRepository;
    private TokenBlacklistRepository tokenBlacklistRepository;

    public AuthController(AuthService authService, JwtUtil jwtUtil, UserRepository userRepository, TokenBlacklistRepository tokenBlacklistRepository) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.tokenBlacklistRepository = tokenBlacklistRepository;
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        String token = authService.login(authRequest);
        return  token;

           }

    @PostMapping("/logout")
    public String logout(@RequestHeader("Authorization") String token) {
        String jwtToken = token.substring(7); // Remove "Bearer " prefix
        TokenBlacklist tokenBlacklist = new TokenBlacklist();
        tokenBlacklist.setToken(jwtToken);
        tokenBlacklist.setExpirationDate(jwtUtil.getExpirationDateFromToken(jwtToken));
        tokenBlacklistRepository.save(tokenBlacklist);

        return "User logged out successfully";
    }
}
