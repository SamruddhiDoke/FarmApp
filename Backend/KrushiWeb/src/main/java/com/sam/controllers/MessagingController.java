package com.sam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sam.dto.MessageResponseDTO;
import com.sam.dto.SendMessageRequest;
import com.sam.services.MessagingService;

@RestController
@RequestMapping("/api/v1/messages")
@CrossOrigin("*")
public class MessagingController {

    @Autowired
    private MessagingService messagingService;

    // Send message (Contact / Negotiate)
    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody SendMessageRequest request) {
        messagingService.sendMessage(request);
        return ResponseEntity.ok("Message sent");
    }

    // Get full chat
    @GetMapping("/conversation/{conversationId}")
    public ResponseEntity<List<MessageResponseDTO>> getMessages(
            @PathVariable Long conversationId) {

        return ResponseEntity.ok(
                messagingService.getConversationMessages(conversationId));
    }
}
