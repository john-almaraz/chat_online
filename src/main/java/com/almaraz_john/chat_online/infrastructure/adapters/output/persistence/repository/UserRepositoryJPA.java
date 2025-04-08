package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.repository;

import com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepositoryJPA extends JpaRepository<UserEntity, UUID> {
    //List<UserEntity> findUserById(List<UUID> userId);
}
