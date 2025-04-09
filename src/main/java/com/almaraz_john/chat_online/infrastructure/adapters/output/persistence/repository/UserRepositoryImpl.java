package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.repository;

import com.almaraz_john.chat_online.application.ports.output.UserRepository;
import com.almaraz_john.chat_online.common.mapper.IdMapper;
import com.almaraz_john.chat_online.domain.aggregate.User;
import com.almaraz_john.chat_online.domain.vo.ID;
import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity.UserEntity;
import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.mapper.UserPersistenceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA repositoryJPA;
    private final UserPersistenceMapper userMapper;
    private final IdMapper idMapper;


    @Override
    public User createUser(User user) {
        UserEntity entity = userMapper.toEntity(user);

        return userMapper.toDomain(repositoryJPA.save(entity));
    }

    @Override
    public Optional<User> getUserByID(ID userID) {
        Optional<UserEntity> entity = repositoryJPA.findById(userID.getValue());

        return entity.map(userMapper::toDomain);
    }

    @Override
    public List<User> getUsersByIDs(List<ID> userIDs) {
        List<UUID> uuidList = idMapper.listIdToUUID(userIDs);

        return userMapper.toListDomain(repositoryJPA.findAllById(uuidList));
    }
}
