package com.example.drone.model;

import com.example.drone.contants.DroneState;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tb_drone_audit")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DroneAudit extends  BaseEntity{
    @ManyToOne
    private Drone drone;
    private int batteryPercentage;
    @Enumerated(EnumType.STRING)
    private DroneState droneState;
}
