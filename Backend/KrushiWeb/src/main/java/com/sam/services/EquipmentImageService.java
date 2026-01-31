package com.sam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.models.Equipment;
import com.sam.models.EquipmentImage;
import com.sam.repositories.EquipmentImageRepository;
import com.sam.repositories.EquipmentRepository;

@Service
public class EquipmentImageService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentImageRepository imageRepository;

    public void addImage(Long equipmentId, String imageUrl) {

        Equipment equipment = equipmentRepository.findById(equipmentId)
                .orElseThrow(() -> new RuntimeException("Equipment not found"));

        EquipmentImage image = new EquipmentImage();
        image.setImageUrl(imageUrl);
        image.setEquipment(equipment);

        imageRepository.save(image);
    }
}
