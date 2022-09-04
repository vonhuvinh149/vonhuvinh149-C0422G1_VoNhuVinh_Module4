package com.furma.service.facility.impl;

import com.furma.model.facility.Facility;
import com.furma.repository.IFacilityRepository;
import com.furma.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;


    @Override
    public Page<Facility> findAll(Pageable pageable) {

        return this.facilityRepository.findAll(pageable);

    }




    @Override
    public Facility findById(int id) {
        return this.facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        this.facilityRepository.deleteById(id);
    }

    @Override
    public void save(Facility facility) {
        this.facilityRepository.save(facility);

    }

    @Override
    public Page<Facility> findByNameFacilityContaining(String facilityName, Pageable pageable) {
        return this.facilityRepository.findByNameFacilityContaining(facilityName,pageable);
    }
}
