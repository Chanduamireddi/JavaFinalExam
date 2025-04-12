package com.sca.spring.finalex.controller;

import com.sca.spring.finalex.model.Customer;
import com.sca.spring.finalex.model.Payment;
import com.sca.spring.finalex.model.Reservation;
import com.sca.spring.finalex.service.CustomerService;
import com.sca.spring.finalex.service.PaymentService;
import com.sca.spring.finalex.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/form")
    public String showReservationForm() {
        return "reservation_form";
    }

    @PostMapping("/submit")
    public String submitReservation(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String address,
            @RequestParam int passengerCount,
            @RequestParam String travelClass,
            @RequestParam String phone,
            @RequestParam String departureDateTime
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime departureTime = LocalDateTime.parse(departureDateTime, formatter);

        Reservation reservation = reservationService.createReservation(firstName, lastName, departureTime);
        customerService.addCustomer(firstName, lastName, address, reservation);
        paymentService.createPayment(reservation.getId(), passengerCount);

        return "redirect:/reservations/list";
    }

    @GetMapping("/list")
    public String viewAllReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservation_list";
    }
}