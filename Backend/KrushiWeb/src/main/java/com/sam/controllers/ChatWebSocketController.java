package com.sam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;

import com.sam.dto.ChatMessageDTO;
import com.sam.services.ChatService;

@Controller
public class ChatWebSocketController {

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat.send")
    public void send(ChatMessageDTO message) {
        chatService.processMessage(message);
    }
}
