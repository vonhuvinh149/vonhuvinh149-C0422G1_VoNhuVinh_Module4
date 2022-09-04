package com.furma.service.facility.impl;

import com.furma.model.facility.RentType;
import com.furma.repository.IRentTypeRepository;
import com.furma.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {

    @Autowired
    private IRentTypeRepository rentTypeRepository ;

    @Override
    public List<RentType> findAll() {
        return this.rentTypeRepository.findAll();
    }
}
