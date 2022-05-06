package com.shop.association.controller;

import com.shop.association.domain.bidirection.joincolumn.User3;
import com.shop.association.model.LoginRequest;
import com.shop.association.service.User3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/uaa")
@CrossOrigin
@RequiredArgsConstructor
public class UaaController {
    private final User3Service user3Service;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = user3Service.login(loginRequest);
        return ResponseEntity.ok().body(loginResponse);
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User3 user3) {
        user3Service.save(user3);
    }
}
