package com.labs.Tracking.controller;

import com.labs.Tracking.model.TrackingNumber;
import com.labs.Tracking.service.TrackingNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tracking")
public class TrackingNumberController {

    private final TrackingNumberService service;

    @Autowired
    public TrackingNumberController(TrackingNumberService service) {
        this.service = service;
    }

    @PostMapping("/generate")
    public TrackingNumber generateTrackingNumber() {
        return service.generateTrackingNumber();
    }
}
