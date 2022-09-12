package com.example.drone.repository;

import com.example.drone.model.DeliveryLoad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DeliveryLoadRepository extends JpaRepository<DeliveryLoad,Long> {
    Optional<DeliveryLoad> findDeliveryLoadByDeliveryIdAndMedicineIdAndSoftDeleteFalse(long deliveryId,long medicineId);
    @Query(nativeQuery = true,value = "select * from tb_delivery_load dl " +
            "inner join tb_delivery d on d.id= dl.delivery_id" +
            " inner join tb_drone dr  on d.drone_id=dr.id" +
            " where d.delivery_status='LOADING' or d.delivery_status='DELIVERING' and dr.id=:droneId")
    List<DeliveryLoad> checkLoadedMedicationOnDrone(long droneId);
}
