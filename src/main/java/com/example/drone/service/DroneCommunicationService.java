package com.example.drone.service;

import com.example.drone.contants.DroneState;
import com.example.drone.model.Drone;

public interface DroneCommunicationService  {
    int getDronePercentage(Drone drone);
    DroneState getDroneSate(Drone drone);

}
