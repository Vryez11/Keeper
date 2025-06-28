package com.keeper.keeperapp.store.dto;

import lombok.Getter;

@Getter
public class StoreSignupRequest {
    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    private String businessNumber;
    private String businessName;
    private String representativeName;

    private String storeName;
    private String storeAddress;
    private String storePhoneNumber;
    private String storeDescription;
}
