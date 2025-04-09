package com.almaraz_john.chat_online.application.mapper;

import com.almaraz_john.chat_online.application.dto.MessageDTO;
import com.almaraz_john.chat_online.common.mapper.IdMapper;
import com.almaraz_john.chat_online.domain.model.Message;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = { IdMapper.class })
public interface MessageMapper {

    @Mappings({
            @Mapping(target = "id", source = "id", qualifiedByName = "idToUUID"),
            @Mapping(target = "fromUserID", source = "fromUser.id", qualifiedByName = "idToUUID"),
            @Mapping(target = "conversationID", source = "conversation.id", qualifiedByName = "idToUUID")
    })
    MessageDTO toDTO(Message message);

}
