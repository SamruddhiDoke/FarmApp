package com.sam.dto;

import lombok.*;

@Data
public class SendMessageRequest {
    private String listingType;   // EQUIPMENT / LAND
    private Long listingId;
    private Long senderId;
    private Long receiverId;
    private String message;
}
