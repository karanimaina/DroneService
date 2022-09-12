package com.example.drone.service;

import com.example.drone.model.Drone;
import com.example.drone.model.DroneAudit;

import java.util.Date;
import java.util.List;

public class DroneAuditServiceImpl implements DroneAuditService {

    @Override
    public void checkDronePercentages() {
    }

    @Override
    public List<DroneAudit> getDroneAuditByTimeRange(long droneId, Date startDate, Date endDate) {
        return null;
    }
}
