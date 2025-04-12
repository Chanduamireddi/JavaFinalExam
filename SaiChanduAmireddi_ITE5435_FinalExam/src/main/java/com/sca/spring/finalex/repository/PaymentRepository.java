package com.sca.spring.finalex.repository;

import com.sca.spring.finalex.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}