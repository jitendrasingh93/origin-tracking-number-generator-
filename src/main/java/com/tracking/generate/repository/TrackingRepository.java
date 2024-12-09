package com.tracking.generate.repository;

import com.tracking.generate.entity.ParcelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackingRepository extends JpaRepository<ParcelDetails, Long> {
}
