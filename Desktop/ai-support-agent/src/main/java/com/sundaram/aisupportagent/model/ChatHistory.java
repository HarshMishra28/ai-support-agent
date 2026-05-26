package com.sundaram.aisupportagent.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "chat_history")
public class ChatHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="session_id")
    private String sessionId;

    @Column(name="user_message", columnDefinition = "Text")
    private String userMessage;

    @Column(name="bot_reply", columnDefinition = "Text")
    private String botReply;

    @Column(name= "timestamp")
    private LocalDateTime timestamp;

    
}
