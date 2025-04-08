package com.almaraz_john.chat_online.application.mapper;

import com.almaraz_john.chat_online.application.dto.ConversationDTO;
import com.almaraz_john.chat_online.domain.model.Conversation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConversationMapper {
    ConversationDTO toDTO(Conversation conversation);
    List<ConversationDTO> toListDTO(List<Conversation> conversationList);
}
