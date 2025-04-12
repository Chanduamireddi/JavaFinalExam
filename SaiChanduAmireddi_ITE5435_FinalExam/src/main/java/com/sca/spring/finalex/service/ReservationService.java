package com.sca.spring.finalex.service;

import com.sca.spring.finalex.model.Reservation;
import com.sca.spring.finalex.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(String firstName, String lastName, LocalDateTime departureDateTime) {
        String details = firstName + " " + lastName;
        String ticketNumber = "TICKET" + UUID.randomUUID().toString().substring(0, 8);

        Reservation reservation = new Reservation();
        reservation.setDetails(details);
        reservation.setTicketnumber(ticketNumber);
        reservation.setDate(departureDateTime);

        return reservationRepository.save(reservation);
    }

    public Reservation getReservationById(String id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}