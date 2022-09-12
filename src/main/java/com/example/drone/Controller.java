package com.example.drone;

import com.example.drone.dto.LoadDroneDto;
import com.example.drone.model.Delivery;
import com.example.drone.model.DeliveryLoad;
import com.example.drone.model.Drone;
import com.example.drone.service.DroneAuditService;
import com.example.drone.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@RestController
@RequestMapping("/api/v1/drone")
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
        }).publishOn(Schedulers.boundedElastic())
    }

    @GetMapping("/loaded/medication")
    public Mono<ResponseEntity<UniversalResponse>>getLoadedMedication(@RequestParam long droneId){
        List<DeliveryLoad>deliveryLoad  =droneService.checkLoadedMedication(droneId);
        UniversalResponse response = UniversalResponse.builder()
                .status(200)
                .message("loaded Medication")
                .data(deliveryLoad)
                .build();
       return  ResponseEntity.ok().body(response)

    })
    }

}
