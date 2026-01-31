package com.sam.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipment_images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;
}
