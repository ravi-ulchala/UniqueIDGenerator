package com.labs.Tracking.repository;

import com.labs.Tracking.model.TrackingNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingNumberRepository extends JpaRepository<TrackingNumber, String> {
    boolean existsByUniqueValue(String uniqueValue);
}
