package com.almaraz_john.chat_online.application.ports.output;

import com.almaraz_john.chat_online.domain.model.Conversation;
import com.almaraz_john.chat_online.domain.vo.ID;

import java.util.List;
import java.util.Optional;

public interface ConversationRepository {
    Conversation createConversation(Conversation conversation);
    Optional<Conversation> getConversationByID(ID id);
    List<Conversation> getAllConversationsFromUser(ID userID);
    void deleteConversation(ID id);
}
