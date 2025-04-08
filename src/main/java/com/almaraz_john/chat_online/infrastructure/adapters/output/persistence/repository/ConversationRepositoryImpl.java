package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.repository;

import com.almaraz_john.chat_online.application.ports.output.ConversationRepository;
import com.almaraz_john.chat_online.domain.model.Conversation;
import com.almaraz_john.chat_online.domain.vo.ID;
import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.mapper.ConversationPersistenceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ConversationRepositoryImpl implements ConversationRepository {

    private final ConversationRepositoryJPA repositoryJPA;
    private final ConversationPersistenceMapper mapper;


    @Override
    public Conversation createConversation(Conversation conversation) {
        return null;
    }

    @Override
    public Optional<Conversation> getConversationByID(ID id) {
        return Optional.empty();
    }

    @Override
    public List<Conversation> getAllConversationsFromUser(ID userID) {
        return List.of();
    }

    @Override
    public void deleteConversation(ID id) {

    }
}
