package com.example.drone.service;

import com.example.drone.model.Drone;
import com.example.drone.model.DroneAudit;
import com.example.drone.repository.DroneAuditRepository;
import com.example.drone.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

@Service
@RequiredArgsConstructor
public class DroneAuditServiceImpl implements DroneAuditService {
    private final DroneAuditRepository droneAuditRepository;
    private final DroneCommunicationService droneCommunicationService;
    private final DroneRepository droneRepository;
    @Autowired
    @Qualifier("auditExecutor")
    private Executor executor;
    @Override
    public void checkDronePercentages() {
    }
    @Override
    public List<DroneAudit> getDroneAuditByTimeRange(long droneId, Date startDate, Date endDate) {
        return null;
    }
}
