package com.labs.Tracking.service;

import com.labs.Tracking.model.TrackingNumber;
import com.labs.Tracking.repository.TrackingNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TrackingNumberService {

    private final TrackingNumberRepository repository;

    @Autowired
    public TrackingNumberService(TrackingNumberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public TrackingNumber generateTrackingNumber() {
        TrackingNumber trackingNumber = new TrackingNumber();
        return repository.save(trackingNumber);
    }
}
