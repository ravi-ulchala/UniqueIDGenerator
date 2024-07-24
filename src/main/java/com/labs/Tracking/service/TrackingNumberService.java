package com.labs.Tracking.service;

import com.labs.Tracking.model.TrackingNumber;
import com.labs.Tracking.repository.TrackingNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
@Service
public class TrackingNumberService {

    private final TrackingNumberRepository repository;

    @Autowired
    public TrackingNumberService(TrackingNumberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Retryable(
            value = { RuntimeException.class },
            maxAttempts = 5,
            backoff = @Backoff(delay = 2000))
    public TrackingNumber generateTrackingNumber() {
        TrackingNumber trackingNumber = new TrackingNumber();
        return repository.save(trackingNumber);
    }
}