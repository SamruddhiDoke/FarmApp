package com.sam.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.dto.EquipmentCardDTO;
import com.sam.models.Equipment;
import com.sam.models.EquipmentImage;
import com.sam.models.User;
import com.sam.repositories.EquipmentRepository;
import com.sam.repositories.UserRepository;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private UserRepository userRepository;

    public Equipment addEquipment(Long userId, Equipment equipment) {

        User owner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        equipment.setOwner(owner);
        equipment.setLocation(owner.getLocation());

        return equipmentRepository.save(equipment);
    }

    public List<EquipmentCardDTO> getEquipmentByLocation(String location) {

        return equipmentRepository.findByLocationAndAvailableTrue(location)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EquipmentCardDTO convertToDTO(Equipment equipment) {

        String imageUrl = equipment.getImages() != null && !equipment.getImages().isEmpty()
                ? equipment.getImages().get(0).getImageUrl()
                : null;

        return new EquipmentCardDTO(
                equipment.getId(),
                equipment.getTitle(),
                equipment.getLocation(),
                equipment.getPricePerDay(),
                imageUrl,
                equipment.getOwner().getName()
        );
    }
}
