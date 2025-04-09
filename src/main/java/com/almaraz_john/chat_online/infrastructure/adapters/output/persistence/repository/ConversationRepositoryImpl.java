package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.repository;

import com.almaraz_john.chat_online.application.ports.output.ConversationRepository;
import com.almaraz_john.chat_online.domain.model.Conversation;
import com.almaraz_john.chat_online.domain.vo.ID;
import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity.ConversationEntity;
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
        ConversationEntity entity = mapper.toEntity(conversation);

        return mapper.toDomain(repositoryJPA.save(entity));
    }

    @Override
    public Optional<Conversation> getConversationByID(ID id) {
        Optional<ConversationEntity> entity = repositoryJPA.findById(id.getValue());

        return entity.map(mapper::toDomain);
    }

    @Override
    public List<Conversation> getAllConversationsFromUser(ID userID) {
        List<ConversationEntity> entityList = repositoryJPA.findAllByUserEntities_Id(userID.getValue());

        return mapper.toListDomain(entityList);
    }

    @Override
    public void deleteConversation(ID id) {
        repositoryJPA.deleteById(id.getValue());
    }
}
