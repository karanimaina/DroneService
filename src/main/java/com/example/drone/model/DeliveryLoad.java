package com.example.drone.model;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@Table
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryLoad {
    @ManyToOne
    private Drone drone;
    @Enumerated (EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private double loadWeight = 0;
}
