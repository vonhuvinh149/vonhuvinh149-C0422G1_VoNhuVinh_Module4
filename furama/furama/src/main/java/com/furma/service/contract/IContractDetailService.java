package com.furma.service.contract;

import com.furma.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAllByContract_IdContract(Integer id);
}
