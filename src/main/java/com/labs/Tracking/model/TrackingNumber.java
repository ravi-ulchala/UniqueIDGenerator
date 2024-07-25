package com.labs.Tracking.model;



import lombok.Data;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.UUID;

@Entity
@Data
public class TrackingNumber {
    @Id
    private String id;
    private Instant timestamp;
    private String uniqueValue;

    public TrackingNumber() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = Instant.now();
        this.uniqueValue = this.id + "-" + this.timestamp.toEpochMilli();
    }
}
