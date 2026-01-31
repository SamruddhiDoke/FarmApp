package com.sam.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sam.dto.MessageResponseDTO;
import com.sam.dto.SendMessageRequest;
import com.sam.models.*;
import com.sam.repositories.*;

@Service
public class MessagingService {

    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public void sendMessage(SendMessageRequest request) {

        User sender = userRepository.findById(request.getSenderId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        User receiver = userRepository.findById(request.getReceiverId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        User buyer = sender.getId().equals(request.getSenderId()) ? sender : receiver;
        User owner = sender.getId().equals(request.getSenderId()) ? receiver : sender;

        Conversation conversation = conversationRepository
                .findByListingTypeAndListingIdAndBuyer_IdAndOwner_Id(
                        request.getListingType(),
                        request.getListingId(),
                        buyer.getId(),
                        owner.getId())
                .orElseGet(() -> {
                    Conversation c = new Conversation();
                    c.setListingType(request.getListingType());
                    c.setListingId(request.getListingId());
                    c.setBuyer(buyer);
                    c.setOwner(owner);
                    return conversationRepository.save(c);
                });

        Message message = new Message();
        message.setConversation(conversation);
        message.setSender(sender);
        message.setContent(request.getMessage());

        messageRepository.save(message);
    }

    public List<MessageResponseDTO> getConversationMessages(Long conversationId) {

        return messageRepository.findByConversation_IdOrderBySentAtAsc(conversationId)
                .stream()
                .map(m -> new MessageResponseDTO(
                        m.getId(),
                        m.getSender().getName(),
                        m.getContent(),
                        m.getSentAt()))
                .collect(Collectors.toList());
    }
}
