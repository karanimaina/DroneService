package com.example.drone.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

public class DroneAudit extends  BaseEntity{
    @ManyToOne
    private Drone drone;
    private int batteryPercentage;
    @Enumerated(EnumType.STRING)
    private DroneState droneState;
}
