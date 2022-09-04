package com.furma.repository;


import com.furma.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    Page<Facility> findByNameFacilityContaining(
            String facilityName, Pageable pageable);

}
