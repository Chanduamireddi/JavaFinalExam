package com.sca.spring.finalex.service;

import com.sca.spring.finalex.model.Payment;
import com.sca.spring.finalex.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    private static final double RATE_PER_PASSENGER = 100.0;

    public Payment createPayment(String reservationId, int passengerCount) {
        double amount = passengerCount * RATE_PER_PASSENGER;
        Payment payment = new Payment();
        payment.setId(reservationId);
        payment.setAmount(amount);
        payment.setDate(LocalDateTime.now());

        return paymentRepository.save(payment);
    }
}