package com.furma.service.contract.impl;

import com.furma.model.contract.Contract;
import com.furma.repository.contract.IContractRepository;
import com.furma.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository ;

    @Override
    public Page<Contract> findAllByEndDateGreaterThanAndCustomer_NameContaining(String day,String nameCustomer,Pageable pageable) {
        return this.contractRepository.findAllByEndDateGreaterThanAndCustomer_NameContaining(day,nameCustomer,pageable);
    }
}
