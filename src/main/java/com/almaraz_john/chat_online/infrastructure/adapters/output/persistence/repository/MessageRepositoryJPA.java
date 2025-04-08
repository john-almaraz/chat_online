package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.repository;

import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageRepositoryJPA extends JpaRepository<MessageEntity, UUID> {
}
