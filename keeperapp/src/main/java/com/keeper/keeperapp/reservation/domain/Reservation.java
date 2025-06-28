package com.keeper.keeperapp.reservation.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String phoneNumber;

    private LocalDateTime requestTime;
    private LocalDateTime startTime;

    private int duration;
    private int price;
    private int bagCount;

    private String message;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    public enum ReservationStatus {
        PENDING, CONFIRMED, REJECTED, COMPLETED
    }

    public void confirm() {
        this.status = ReservationStatus.CONFIRMED;
    }

    public void reject() {
        this.status = ReservationStatus.REJECTED;
    }
}
