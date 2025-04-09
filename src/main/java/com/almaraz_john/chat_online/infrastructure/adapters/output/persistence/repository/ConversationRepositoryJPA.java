package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.repository;

import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity.ConversationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ConversationRepositoryJPA extends JpaRepository<ConversationEntity, UUID> {
    List<ConversationEntity> findAllByUserEntities_Id(UUID userId);

}
