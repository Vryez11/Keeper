package com.keeper.keeperapp.store.service;

import com.keeper.keeperapp.store.domain.Store;
import com.keeper.keeperapp.store.dto.LoginRequest;
import com.keeper.keeperapp.store.dto.StoreSignupRequest;
import com.keeper.keeperapp.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreAuthService {

    private final StoreRepository storeRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(StoreSignupRequest request) {
        if (storeRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        Store store = Store.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .businessNumber(request.getBusinessNumber())
                .businessName(request.getBusinessName())
                .representativeName(request.getRepresentativeName())
                .storeName(request.getStoreName())
                .storeAddress(request.getStoreAddress())
                .storePhoneNumber(request.getStorePhoneNumber())
                .storeDescription(request.getStoreDescription())
                .build();

        storeRepository.save(store);
    }

    public void login(LoginRequest request) {
        Store store = storeRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("등록되지 않는 이메일입니다."));

        if (!passwordEncoder.matches(request.getPassword(), store.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
