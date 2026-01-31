package com.sam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.models.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

    List<Equipment> findByLocationAndAvailableTrue(String location);

    List<Equipment> findByCategoryAndAvailableTrue(String category);
}
