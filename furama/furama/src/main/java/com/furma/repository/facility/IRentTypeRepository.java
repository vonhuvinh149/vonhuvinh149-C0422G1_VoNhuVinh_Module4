package com.furma.repository.facility;

import com.furma.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType , Integer> {
}
