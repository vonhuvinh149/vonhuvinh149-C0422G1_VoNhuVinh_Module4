package com.furma.service.facility.impl;

import com.furma.model.facility.FacilityType;
import com.furma.repository.facility.IFacilityTypeRepository;
import com.furma.service.facility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return this.facilityTypeRepository.findAll();
    }


}
