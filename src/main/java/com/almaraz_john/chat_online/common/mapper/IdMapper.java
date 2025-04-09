package com.almaraz_john.chat_online.common.mapper;

import com.almaraz_john.chat_online.domain.vo.ID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface IdMapper {

    @Named("idToUUID")
    default UUID idToUUID(ID id) {
        return id == null ? null : id.getValue();
    }

    @Named("uuidToID")
    default ID uuidToID(UUID uuid) {
        return uuid == null ? null : ID.of(uuid);
    }

    @Named("listIdToUUID")
    default List<UUID> listIdToUUID(List<ID> ids) {
        if (ids == null) {
            return null;
        }
        return ids.stream()
                .map(this::idToUUID)
                .collect(Collectors.toList());
    }

    @Named("listUuidToID")
    default List<ID> listUuidToID(List<UUID> uuids) {
        if (uuids == null) {
            return null;
        }
        return uuids.stream()
                .map(this::uuidToID)
                .collect(Collectors.toList());
    }

}
