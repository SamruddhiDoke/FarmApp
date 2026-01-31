package com.sam.models;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Conversation conversation;

    @ManyToOne
    private User sender;

    @Column(length = 1000)
    private String content;

    private LocalDateTime sentAt;

    @PrePersist
    protected void onSend() {
        sentAt = LocalDateTime.now();
    }
}
