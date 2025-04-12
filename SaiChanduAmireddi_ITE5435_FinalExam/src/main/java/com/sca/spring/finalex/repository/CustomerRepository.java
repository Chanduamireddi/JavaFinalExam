package com.sca.spring.finalex.repository;

import com.sca.spring.finalex.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}