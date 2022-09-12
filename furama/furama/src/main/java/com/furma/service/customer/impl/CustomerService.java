package com.furma.service.customer.impl;

import com.furma.model.customer.Customer;
import com.furma.repository.customer.ICustomerRepository;
import com.furma.service.customer.ICustomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomeService {

    @Autowired
    private ICustomerRepository furamaRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return furamaRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByNameContaining(String name, Pageable pageable) {
        return this.furamaRepository.findByNameContaining(name,pageable);
    }

    @Override
    public Customer findById(int id) {
        return this.furamaRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.furamaRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
     this.furamaRepository.deleteById(id);
    }
}
