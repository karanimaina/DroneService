package com.example.drone.repository;

import com.example.drone.model.DroneAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DroneAuditRepository extends JpaRepository<DroneAudit,Long> {
    List<DroneAudit> findAllByDroneIdAndCreatedOnBetween(long droneId, Date startDate, Date endDate);
}
