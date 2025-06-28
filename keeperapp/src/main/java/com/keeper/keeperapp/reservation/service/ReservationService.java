package com.keeper.keeperapp.reservation.service;

import com.keeper.keeperapp.reservation.domain.Reservation;
import com.keeper.keeperapp.reservation.dto.ReservationRequestDto;
import com.keeper.keeperapp.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public Reservation save(ReservationRequestDto dto) {
        Reservation reservation = Reservation.builder()
                .customerName(dto.getCustomerName())
                .phoneNumber(dto.getPhoneNumber())
                .requestTime(dto.getRequestTime())
                .startTime(dto.getStartTime())
                .duration(dto.getDuration())
                .price(dto.getPrice())
                .bagCount(dto.getBagCount())
                .message(dto.getMessage())
                .status(Reservation.ReservationStatus.PENDING)
                .build();

        return reservationRepository.save(reservation);
    }

    public void confirm(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("예약이 존재하지 않습니다."));
        reservation.confirm();
        reservationRepository.save(reservation);
    }

    public void reject(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("예약이 존재하지 않습니다."));
        reservation.reject();
        reservationRepository.save(reservation);
    }

    public List<Reservation> findAllPending() {
        return reservationRepository.findByStatus(Reservation.ReservationStatus.PENDING);
    }

    public List<Reservation> findAllConfirmed() {
        return reservationRepository.findByStatus(Reservation.ReservationStatus.CONFIRMED);
    }
}
