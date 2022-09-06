package com.furma.repository;

import com.furma.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

    Page<Customer> findByNameContaining (String name, Pageable pageable);
}