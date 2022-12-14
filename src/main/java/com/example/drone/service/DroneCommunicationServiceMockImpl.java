package com.example.drone.service;

import com.example.drone.contants.DroneState;
import com.example.drone.model.Drone;
import org.springframework.stereotype.Service;

@Service
public class DroneCommunicationServiceMockImpl  implements DroneCommunicationService {
    @Override
    public int getDronePercentage(Drone drone) {
        return drone.getBatteryPercentage()-1;
    }

    @Override
    public DroneState getDroneState(Drone drone) {
        return  drone.getState();
    }


}
