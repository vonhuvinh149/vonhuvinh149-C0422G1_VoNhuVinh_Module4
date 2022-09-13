package com.furma.service.contract.impl;

import com.furma.model.contract.AttachFacility;
import com.furma.model.contract.Contract;
import com.furma.model.contract.ContractDetail;
import com.furma.repository.contract.IAttachFacilityRepository;
import com.furma.repository.contract.IContractDetailRepository;
import com.furma.repository.contract.IContractRepository;
import com.furma.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractRepository contractRepository ;

    @Autowired
    private IContractDetailRepository contractDetailRepository ;

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public Page<Contract> findAllByEndDateGreaterThanAndCustomer_NameContaining(String day,String nameCustomer,Pageable pageable) {

        Page<Contract> contractList = this.contractRepository.findAllByEndDateGreaterThanAndCustomer_NameContaining(day,nameCustomer,pageable);;
        List<AttachFacility> attachFacilityList = attachFacilityRepository.findAll();
        List<ContractDetail> contractDetailList = contractDetailRepository.findAll();
        for (Contract c: contractList) {
            double totalDetail = 0;
            double costFacility = 0;
            for (ContractDetail item : contractDetailList) {
                if (item.getContract().getIdContract() == c.getIdContract()) {
                    for (AttachFacility attach : attachFacilityList) {
                        if (attach.getIdAttachFacility() == item.getAttachFacility().getIdAttachFacility()) {
                            costFacility += item.getQuantity() * attach.getCost();
                        }
                    }
                }
            }
            totalDetail = costFacility + c.getFacility().getCost();
            c.setTotalMoney(totalDetail);
        }
        return contractList;

    }
}
