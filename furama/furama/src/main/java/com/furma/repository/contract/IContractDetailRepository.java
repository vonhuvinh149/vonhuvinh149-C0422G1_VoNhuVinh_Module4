package com.furma.repository.contract;

import com.furma.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail , Integer> {
    List<ContractDetail> findAllByContract_IdContract(Integer id);
}
