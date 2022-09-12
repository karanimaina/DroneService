package com.example.drone.repository;

import com.example.drone.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {
    Optional<Medicine> findMedicineByIdAndSoftDeleteFalse(long medicineId);
}
