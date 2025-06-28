package com.keeper.keeperapp.reservation.repository;

import com.keeper.keeperapp.reservation.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStatus(Reservation.ReservationStatus status);
}
