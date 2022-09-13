package com.furma.service.customer;

import com.furma.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByNameContaining(String name, Pageable pageable);

    Customer findById(int id);

    void save(Customer customer);

    void deleteById(int id);



}
