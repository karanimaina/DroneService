package com.example.drone.service;

import com.example.drone.model.DroneAudit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface DroneAuditService {
    void checkDronePercentages();
    List<DroneAudit>getDroneAuditByTimeRange(long droneId, Date startDate, Date endDate);
}