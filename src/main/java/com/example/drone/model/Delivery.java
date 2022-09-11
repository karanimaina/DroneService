package com.example.drone.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tb_delivery")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Delivery extends  BaseEntity {
    @ManyToOne
    private Drone drone;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private double loadWeight;

}
