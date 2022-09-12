package com.furma.repository.customer;

import com.furma.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {

}
