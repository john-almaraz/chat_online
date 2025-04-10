package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.mapper;

import com.almaraz_john.chat_online.common.mapper.IdMapper;
import com.almaraz_john.chat_online.domain.aggregate.User;
import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = { IdMapper.class })
public interface UserPersistenceMapper {

    @Mappings({
            @Mapping(target = "id", source = "id", qualifiedByName = "idToUUID"),

    })
    UserEntity toEntity(User user);

    @Mappings({
            @Mapping(target = "id", source = "id", qualifiedByName = "uuidToID")
    })
    User toDomain(UserEntity entity);

    List<User> toListDomain(List<UserEntity> userEntities);
}
