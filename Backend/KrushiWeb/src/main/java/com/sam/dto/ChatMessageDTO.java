package com.sam.dto;

import lombok.*;

@Data
public class ChatMessageDTO {

    private String listingType; 
    private Long listingId;

    private Long senderId;
    private Long receiverId;

    private String message;
}
