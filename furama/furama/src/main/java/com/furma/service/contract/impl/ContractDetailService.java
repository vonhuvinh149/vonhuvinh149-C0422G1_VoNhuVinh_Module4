package com.furma.service.contract.impl;

import com.furma.model.contract.ContractDetail;
import com.furma.repository.contract.IContractDetailRepository;
import com.furma.repository.contract.IContractRepository;
import com.furma.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {

    @Autowired
    private IContractDetailRepository contractDetailRepository ;

    @Override
    public List<ContractDetail> findAllByContract_IdContract(Integer id) {
        return this.contractDetailRepository.findAllByContract_IdContract(id);
    }
}
