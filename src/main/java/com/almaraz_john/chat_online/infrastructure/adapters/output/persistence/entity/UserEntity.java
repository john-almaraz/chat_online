package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private UUID id;

    @NotNull
    private String username;

    @ManyToMany(mappedBy = "userEntities")
    private List<ConversationEntity> conversationEntities;

}
