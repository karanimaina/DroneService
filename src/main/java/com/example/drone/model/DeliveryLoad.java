package com.example.drone.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

public class DeliveryLoad {
    @ManyToOne
    private Drone drone;
    @Enumerated (EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private double loadWeight = 0;
}
