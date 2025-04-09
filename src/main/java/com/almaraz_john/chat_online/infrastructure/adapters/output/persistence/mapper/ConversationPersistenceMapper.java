package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.mapper;

import com.almaraz_john.chat_online.common.mapper.IdMapper;
import com.almaraz_john.chat_online.domain.aggregate.User;
import com.almaraz_john.chat_online.domain.model.Conversation;
import com.almaraz_john.chat_online.domain.vo.ID;
import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity.ConversationEntity;
import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = { IdMapper.class })
public interface ConversationPersistenceMapper {

    @Mappings({
            @Mapping(target = "id", source = "id", qualifiedByName = "idToUUID"),
            @Mapping(target = "userEntities", source = "userList", qualifiedByName = "userListToEntityList")
    })
    ConversationEntity toEntity(Conversation conversation);

    @Mappings({
            @Mapping(target = "id", source = "id", qualifiedByName = "uuidToID"),
            @Mapping(target = "userList", source = "userEntities", qualifiedByName = "entityListToUserList")
    })
    Conversation toDomain(ConversationEntity entity);

    List<Conversation> toListDomain(List<ConversationEntity> conversationEntities);

    List<ConversationEntity> toListEntity(List<Conversation> conversationList);

    @Named("userListToEntityList")
    default List<UserEntity> userListToEntityList(List<User> userList){
        if (userList == null){
            return null;
        }
        return userList.stream()
                .map(user -> new UserEntity(
                        user.getId().getValue(),
                        user.getUsername(),
                        null
                ))
                .collect(Collectors.toList());
    }

    @Named("entityListToUserList")
    default List<User> entityListToUserList(List<UserEntity> userEntities){
        if (userEntities == null){
            return null;
        }
        return userEntities.stream()
                .map(entity -> new User(
                        ID.of(entity.getId()),
                        entity.getUsername(),
                        null
                ))
                .collect(Collectors.toList());
    }
}
