package com.sca.spring.finalex.service;

import com.sca.spring.finalex.model.Customer;
import com.sca.spring.finalex.model.Reservation;
import com.sca.spring.finalex.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(String firstName, String lastName, String address, Reservation reservation) {
        String details = firstName + " " + lastName;
        Customer customer = new Customer();
        customer.setAddress(address);
        customer.setDetails(details);
        customer.setReservation(reservation);

        return customerRepository.save(customer);
    }
}