package com.example.drone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table
@AllArgsConstructor
@Getter
@Setter
=
@NoArgsConstructor
public class drone {
    @Size(min = 3,max = 100)
    private  String serialNo;
    @Enumerated(EnumType.STRING)
    private String model;
    @DecimalMax(value = "500")
    private String weightLimit;
    @Max(value = 100)
    private int batteryPercentage;
    @Enumerated(EnumType.STRING)
    private DroneState state;

}
