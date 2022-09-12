package com.example.drone.repository;

import com.example.drone.contants.DeliveryStatus;
import com.example.drone.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
    Optional<Delivery> findDeliveryByDroneIdAndDeliveryStatusAndSoftDeleteFalse(long droneId, DeliveryStatus deliveryStatus);
}
