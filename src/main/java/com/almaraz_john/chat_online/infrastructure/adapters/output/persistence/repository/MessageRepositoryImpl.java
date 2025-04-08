package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.repository;

import com.almaraz_john.chat_online.application.ports.output.MessageRepository;
import com.almaraz_john.chat_online.domain.model.Message;
import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.mapper.MessagePersistenceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MessageRepositoryImpl implements MessageRepository {

    private final MessageRepositoryJPA repositoryJPA;
    private final MessagePersistenceMapper mapper;

    @Override
    public Message sendMessage(Message message) {
        return null;
    }

    @Override
    public Message receiveMessage() {
        return null;
    }
}
