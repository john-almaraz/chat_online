package com.almaraz_john.chat_online.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@Data
@Entity
@Table(name = "message")
public class MessageEntity {

    @Id
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private UserEntity  fromUser;

    @NotNull
    private String content;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private ConversationEntity conversation;

    @NotNull
    private Instant timeStamp;
}
