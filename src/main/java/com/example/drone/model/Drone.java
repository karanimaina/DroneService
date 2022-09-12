package com.example.drone.model;

import com.example.drone.contants.DroneModel;
import com.example.drone.contants.DroneState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Table
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Drone {
    @Size(min = 3,max = 100)
    private  String serialNo;
    @Enumerated(EnumType.STRING)
    private DroneModel model;
    @DecimalMax(value = "500")
    private String weightLimit;
    @Max(value = 100)
    private int batteryPercentage;
    @Enumerated(EnumType.STRING)
    private DroneState state;
}
