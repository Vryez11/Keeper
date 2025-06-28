package com.keeper.keeperapp.store.controller;

import com.keeper.keeperapp.store.dto.LoginRequest;
import com.keeper.keeperapp.store.dto.StoreSignupRequest;
import com.keeper.keeperapp.store.service.StoreAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class StoreAuthController {
    private final StoreAuthService storeAuthService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody StoreSignupRequest request) {
        storeAuthService.signup(request);
        return ResponseEntity.ok("가입성공");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        storeAuthService.login(request);
        return ResponseEntity.ok("로그인 성공");
    }
}
