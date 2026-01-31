package com.sam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sam.models.EquipmentImage;

public interface EquipmentImageRepository
extends JpaRepository<EquipmentImage, Long> {
}

