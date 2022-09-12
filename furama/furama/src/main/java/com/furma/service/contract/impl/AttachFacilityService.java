package com.furma.service.contract.impl;

import com.furma.model.contract.AttachFacility;
import com.furma.model.contract.ContractDetail;
import com.furma.repository.contract.IAttachFacilityRepository;
import com.furma.service.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    IAttachFacilityRepository attachFacilityRepository ;

}
