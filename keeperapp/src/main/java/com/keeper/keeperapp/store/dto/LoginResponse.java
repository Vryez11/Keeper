package com.keeper.keeperapp.store.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
@Getter
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private String storeName;
    private String email;
    private String storePhoneNumber;
    private String storeAddress;
    private String storeDescription;
    private String businessNumber;
    private String representativeName;
}
