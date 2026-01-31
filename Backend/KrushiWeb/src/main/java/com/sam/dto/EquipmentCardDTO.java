package com.sam.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentCardDTO {

    private Long id;
    private String title;
    private String location;
    private double pricePerDay;
    private String imageUrl;
    private String ownerName;
}
