package com.example.drone;

import com.example.drone.model.Drone;
import com.example.drone.service.DroneAuditService;
import com.example.drone.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class Controller {
    private final DroneService droneService;
    private final DroneAuditService droneAuditService;

    @PostMapping("/create")
    public Mono<ResponseEntity<UniversalResponse>>registerDrone(@RequestBody Drone drone){
        return  Mono.fromCallable(() ->{
            Drone registeredDrone = droneService.registerDrone(drone);
            UniversalResponse response = UniversalResponse.builder().status(200)
                    .data(registeredDrone)
                    .message("drone registered sucesfully")
                    .build();
           return ResponseEntity.ok(response);
        }).publishOn(Schedulers.boundedElastic());
    }

}
