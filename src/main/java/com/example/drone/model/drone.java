package com.example.drone.model;

import lombok.AllArgsConstructor;

import javax.persistence.Table;


public class drone {

    private  String serialNo;
    private String model;
    private String weightLimit;
    private int batteryPercentage;
    private DroneState state;

}
