package com.example.shop_clone.controller;

import com.example.shop_clone.modul.userDto.AuthDto;
import com.example.shop_clone.modul.userDto.RegisterDto;
import com.example.shop_clone.servise.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
@AllArgsConstructor
public class AuthController {
    private AuthService authService;
    @PostMapping
    public ResponseEntity<?> register(@RequestBody RegisterDto dto) {
        boolean ans = authService.register(dto);
        return ResponseEntity.ok(ans);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthDto dto) {
        AuthDto ans = authService.login(dto);
        return ResponseEntity.ok(ans);
    }

    @GetMapping("/verification/{token}")
    public ResponseEntity<?> verification(@PathVariable("token") String token) {
        boolean ans = authService.verification(token);
        return ResponseEntity.ok(ans);
    }


}
