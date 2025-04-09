package com.almaraz_john.chat_online.application.mapper;

import com.almaraz_john.chat_online.application.dto.ConversationDTO;
import com.almaraz_john.chat_online.common.mapper.IdMapper;
import com.almaraz_john.chat_online.domain.model.Conversation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = { IdMapper.class })
public interface ConversationMapper {

    @Mappings({
            @Mapping(target = "id", source = "id", qualifiedByName = "idToUUID"),
            @Mapping(target = "userIDs", source = "conversation", qualifiedByName = "conversationToUserIdList")
    })
    ConversationDTO toDTO(Conversation conversation);

    List<ConversationDTO> toListDTO(List<Conversation> conversationList);

    @Named("conversationToUserIdList")
    default List<UUID> conversationToUserIdList(Conversation conversation){
        return conversation.getUserList()
                .stream()
                .map(id -> id.getId().getValue())
                .toList();
    }
}
