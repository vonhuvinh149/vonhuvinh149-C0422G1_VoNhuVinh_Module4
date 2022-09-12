package com.furma.service.customer.impl;

import com.furma.model.customer.CustomerType;
import com.furma.repository.customer.ICustomerTypeRepository;
import com.furma.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {

    @Autowired
    private ICustomerTypeRepository customerRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.customerRepository.findAll();
    }
}
