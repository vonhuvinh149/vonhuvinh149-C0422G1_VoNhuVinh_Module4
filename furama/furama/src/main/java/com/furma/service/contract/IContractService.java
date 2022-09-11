package com.furma.service.contract;

import com.furma.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> findAllByEndDateGreaterThanAndCustomer_NameContaining (String day,String nameCustomer,Pageable pageable);
}
