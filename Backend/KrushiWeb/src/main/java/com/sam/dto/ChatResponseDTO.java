package com.sam.dto;

import java.time.LocalDateTime;
import lombok.*;

@Data
@AllArgsConstructor
public class ChatResponseDTO {

    private Long conversationId;
    private Long messageId;
    private Long senderId;
    private String senderName;
    private String message;
    private LocalDateTime sentAt;
}
