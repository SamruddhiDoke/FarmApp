package com.sam.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
public class MessageResponseDTO {
    private Long id;
    private String senderName;
    private String message;
    private LocalDateTime sentAt;
}
