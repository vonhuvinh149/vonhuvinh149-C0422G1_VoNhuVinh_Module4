package com.furma.service.facility;

import com.furma.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {

    Page<Facility> findAll(Pageable pageable);

    Facility findById(int id);

    void deleteById(int id);

    void save(Facility facility);

    Page<Facility> findByNameFacilityContaining(
            String facilityName, Pageable pageable);

}
