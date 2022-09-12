package com.example.drone.service;

import com.example.drone.model.Delivery;
import com.example.drone.model.DeliveryLoad;
import com.example.drone.model.Drone;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class DroneServiceImpl implements  DroneService{
    @Override
    public Drone registerDrone(Drone drone) {
        return null;
    }

    @Override
    public Delivery loadDrone(long droneId, long medicineId) {
        return null;
    }

    @Override
    public List<DeliveryLoad> checkLoadedMedication(long drone) {
        return null;
    }

    @Override
    public List<Drone> checkAvailableDrones(Pageable pageable) {
        return null;
    }

    @Override
    public int checkDronePercentage(long drone) {
        return 0;
    }
}
