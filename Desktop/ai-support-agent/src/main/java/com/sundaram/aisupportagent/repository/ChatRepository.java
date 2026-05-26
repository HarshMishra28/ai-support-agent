package com.sundaram.aisupportagent.repository;

import com.sundaram.aisupportagent.model.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatHistory, Long> {

}