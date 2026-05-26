package com.sundaram.aisupportagent.service;

import com.sundaram.aisupportagent.repository.ChatRepository;
import com.sundaram.aisupportagent.model.ChatHistory;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
@Service
public class ChatService {
    private final ChatRepository chatRepository;
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    
    }
    public String chat(String userMessage, String sessionId) {

        // Step 1 - Generate response (AI coming in Phase 3)
        String botReply = "Thanks for your message: '" 
            + userMessage 
            + "'. AI response coming in Phase 3!";

        // Step 2 - Save conversation to MySQL
        ChatHistory history = new ChatHistory();
        history.setSessionId(sessionId);
        history.setUserMessage(userMessage);
        history.setBotReply(botReply);
        history.setTimestamp(LocalDateTime.now());
        chatRepository.save(history);

        // Step 3 - Return response to Controller
        return botReply;
    }

}
