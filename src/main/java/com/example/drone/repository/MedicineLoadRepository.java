package com.example.drone.repository;
import com.example.drone.model.DeliveryLoad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineLoadRepository extends JpaRepository<DeliveryLoad,Long> {
}
