package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.repository;

import com.almaraz_john.chat_online.application.ports.output.UserRepository;
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
    private final UserPersistenceMapper mapper;


    @Override
    public User createUser(User user) {
        UserEntity entity = mapper.toEntity(user);

        return mapper.toDomain(repositoryJPA.save(entity));
    }

    @Override
    public Optional<User> getUserByID(ID userID) {
        Optional<UserEntity> entity = repositoryJPA.findById(userID.getValue());

        return entity.map(mapper::toDomain);
    }

    @Override
    public List<User> getUsersByIDs(List<ID> userIDs) {
        List<UUID> uuidList = new ArrayList<>();

        for (ID id:userIDs){
            uuidList.add(id.getValue());
        }

        //return mapper.toListDomain(repositoryJPA.findUserById(uuidList));
        return null;
    }
}
