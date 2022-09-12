package com.example.drone.repository;

import com.example.drone.contants.DroneState;
import com.example.drone.model.Drone;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DroneRepository  extends JpaRepository<Drone,Long> {
    List<Drone> findAllByStateAndSoftDeleteFalse(DroneState droneState, Pageable pageable);
    Optional<Drone>findTopBySerialNoAndSoftDeleteFalse(long id);
    Optional<Drone>findByIdAndSoftDeleteFalse(long id);
    List<Drone>findAllBySoftDeleteFalse ();


}
