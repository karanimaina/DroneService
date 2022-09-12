package com.example.drone.service;

import com.example.drone.contants.DroneState;
import com.example.drone.model.Drone;
import com.example.drone.model.DroneAudit;
import com.example.drone.repository.DroneAuditRepository;
import com.example.drone.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

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
    @Scheduled(fixedDelay = 1000)
    @Override
    public void checkDronePercentages() {
        Mono.fromRunnable (()-> droneRepository.findAllBySoftDeleteFalse ()
                .parallelStream ()

                .forEach (drone -> {
                    int batteryPerc= droneCommunicationService.getDronePercentage (drone);
                    DroneState droneState= droneCommunicationService.getDroneState (drone);
                    drone.setBatteryPercentage (batteryPerc);
                    drone.setState (droneState);

                    droneRepository.save (drone);
                    DroneAudit audit= DroneAudit.builder()
                            .drone (drone)
                            .batteryPercentage (batteryPerc)
                            .build();
                    audit.setDroneState (droneState);
                    droneAuditRepository.save (audit);
                })).subscribeOn (Schedulers.fromExecutor (executor)).subscribe ();
    }
    @Override
    public List<DroneAudit> getDroneAuditByTimeRange(long droneId, Date startDate, Date endDate) {
        Drone drone = droneRepository.findByIdAndSoftDeleteFalse(droneId).orElse(null);
        if (drone == null)
             throw new ItemNotFoundException("Drone not Found");
       return  droneAuditRepository.findAllByDroneIdAndCreatedOnBetween(droneId,startDate,endDate);

    }
}
