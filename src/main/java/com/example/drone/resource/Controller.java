package com.example.drone.resource;

import com.example.drone.UniversalResponse;
import com.example.drone.resource.dto.LoadDroneDto;
import com.example.drone.model.Delivery;
import com.example.drone.model.DeliveryLoad;
import com.example.drone.model.Drone;
import com.example.drone.model.DroneAudit;
import com.example.drone.service.DroneAuditService;
import com.example.drone.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/drone")
@RequiredArgsConstructor
public class Controller {
    private final DroneService droneService;
    private final DroneAuditService droneAuditService;

    @PostMapping("/create")
    public Mono<ResponseEntity<UniversalResponse>>registerDrone(@RequestBody Drone drone){
        return  Mono.fromCallable(() -> {
            Drone registeredDrone = droneService.registerDrone(drone);
            UniversalResponse response = UniversalResponse.builder().status(200)
                    .data(registeredDrone)
                    .message("drone registered sucesfully")
                    .build();
           return ResponseEntity.ok(response);
        }).publishOn(Schedulers.boundedElastic());
    }
    @PostMapping("/load/drone")
    public Mono<ResponseEntity<UniversalResponse>>loadDrone(LoadDroneDto loadDroneDto){
        return  Mono.fromCallable(() -> {
            Delivery delivery = droneService.loadDrone(loadDroneDto.getDroneId(), loadDroneDto.getMedicineId());
            UniversalResponse response = UniversalResponse.builder()
                    .status(200)
                    .message("loaded succesfully")
                    .data(delivery)
                    .build();
            return  ResponseEntity.ok(response);
        }).publishOn(Schedulers.boundedElastic());
    }

    @GetMapping("/loaded/medication")
    public Mono<ResponseEntity<UniversalResponse>>getLoadedMedication(@RequestParam long droneId){
    return Mono.fromCallable(() ->{List<DeliveryLoad>deliveryLoad  =droneService.checkLoadedMedication(droneId);
        UniversalResponse response = UniversalResponse.builder()
                .status(200)
                .message("loaded Medication")
                .data(deliveryLoad)
                .build();
       return  ResponseEntity.ok().body(response);
    }).publishOn(Schedulers.boundedElastic());
    }
    @GetMapping("/available/drone")
    public Mono<ResponseEntity<UniversalResponse>> getAvailableDrone(@RequestParam int size, @RequestParam int page){
        return Mono.fromCallable (()-> {
            Pageable pageable= PageRequest.of (page,size);
            List<Drone> availableDrones= droneService.checkAvailableDrones (pageable);
            UniversalResponse response= UniversalResponse.builder()
                    .status (200)
                    .message ("Available drones")


                    .data (availableDrones)
                    .build();
            return ResponseEntity.ok ().body (response);
        }).publishOn (Schedulers.boundedElastic ());
    }
    @GetMapping("/check/percentage")
    public Mono<ResponseEntity<UniversalResponse>> checkPercentage(@RequestParam int droneId){
        return Mono.fromCallable (()-> {
            int batteryPerc= droneService.checkDronePercentage (droneId);
            UniversalResponse response= UniversalResponse.builder()
                    .status (200)
                    .message ("Battery percentage")
                    .data (Map.of("battery", batteryPerc))
                    .build();
            return ResponseEntity.ok ().body (response);
        }).publishOn (Schedulers.boundedElastic ());
    }

    @GetMapping("/audit/logs")
    public Mono<ResponseEntity<UniversalResponse>>getDroneAuditLogs(@RequestParam long droneId,
                                                                    @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                                                    @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate){
        return Mono.fromCallable (()-> {
            List<DroneAudit> droneAudits= droneAuditService.getDroneAuditByTimeRange (droneId,startDate,endDate);
            UniversalResponse response= UniversalResponse.builder()
                    .status (200)
                    .message ("Drone Audit list")
                    .data (droneAudits)
                    .build();
            return ResponseEntity.ok ().body (response);
        }).publishOn (Schedulers.boundedElastic ());
    }


}
