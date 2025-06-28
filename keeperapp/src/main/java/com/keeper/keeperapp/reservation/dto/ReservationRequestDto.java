package com.keeper.keeperapp.reservation.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReservationRequestDto {

    private String customerName;
    private String phoneNumber;
    private LocalDateTime requestTime;
    private LocalDateTime startTime;
    private int duration;
    private int price;
    private int bagCount;
    private String message;
}
