package com.keeper.keeperapp.store.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Builder
    public Store(String email, String password, String name, String phoneNumber,
                 String businessNumber, String businessName, String representativeName,
                 String storeName, String storeAddress, String storePhoneNumber, String storeDescription) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.businessNumber = businessNumber;
        this.businessName = businessName;
        this.representativeName = representativeName;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.storePhoneNumber = storePhoneNumber;
        this.storeDescription = storeDescription;
    }
}
