package com.example.drone.resource.dto;

import lombok.Data;

@Data
public class LoadDroneDto {
    private final long droneId;
    private final long medicineId;
}
