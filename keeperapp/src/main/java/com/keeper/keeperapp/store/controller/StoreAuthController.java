package com.keeper.keeperapp.store.controller;

import com.keeper.keeperapp.store.domain.Store;
import com.keeper.keeperapp.store.dto.LoginRequest;
import com.keeper.keeperapp.store.dto.LoginResponse;
import com.keeper.keeperapp.store.dto.StoreSignupRequest;
import com.keeper.keeperapp.store.service.StoreAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
        LoginResponse response = storeAuthService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentStoreInfo(@AuthenticationPrincipal Store store) {
        return ResponseEntity.ok(LoginResponse.builder()
                .token(null) // 로그인 아님, null
                .storeName(store.getStoreName())
                .email(store.getEmail())
                .storePhoneNumber(store.getStorePhoneNumber())
                .storeAddress(store.getStoreAddress())
                .storeDescription(store.getStoreDescription())
                .businessNumber(store.getBusinessNumber())
                .representativeName(store.getRepresentativeName())
                .build());
    }
}
