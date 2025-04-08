package com.almaraz_john.chat_online.application.mapper;

import com.almaraz_john.chat_online.application.dto.UserDTO;
import com.almaraz_john.chat_online.common.mapper.IdMapper;
import com.almaraz_john.chat_online.domain.aggregate.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { IdMapper.class })
public interface UserMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "idToUUID")
    UserDTO toDTO(User user);

    @Mapping(target = "id", source = "id", qualifiedByName = "uuidToID")
    @Mapping(target = "conversationList", ignore = true)
    User toDomain(UserDTO userDTO);
}
