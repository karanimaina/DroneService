package com.example.drone.service;

import com.example.drone.model.Delivery;
import com.example.drone.model.DeliveryLoad;
import com.example.drone.model.Drone;
import com.example.drone.repository.DeliveryRepository;
import com.example.drone.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements  DroneService{
    private final DroneRepository droneRepository;
    private final DeliveryRepository deliveryRepository;

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
