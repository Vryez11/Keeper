package com.keeper.keeperapp.reservation.controller;

import com.keeper.keeperapp.reservation.domain.Reservation;
import com.keeper.keeperapp.reservation.dto.ReservationRequestDto;
import com.keeper.keeperapp.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody ReservationRequestDto dto) {
        Reservation saved = reservationService.save(dto);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/{id}/confirm")
    public ResponseEntity<?> confirm(@PathVariable Long id) {
        reservationService.confirm(id);
        return ResponseEntity.ok("예약이 승인되었습니다.");
    }

    @DeleteMapping("/{id}/reject")
    public ResponseEntity<?> reject(@PathVariable Long id) {
        reservationService.reject(id);
        return ResponseEntity.ok("예약이 거절되었습니다.");
    }

    @GetMapping("/pending")
    public ResponseEntity<List<Reservation>> getPending() {
        return ResponseEntity.ok(reservationService.findAllPending());
    }

    @GetMapping("/confirmed")
    public ResponseEntity<List<Reservation>> getConfirmed() {
        return ResponseEntity.ok(reservationService.findAllConfirmed());
    }
}
