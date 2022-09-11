package com.furma.repository;

import com.furma.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByEndDateGreaterThanAndCustomer_NameContaining(String day, String nameCustomer, Pageable pageable);
}
