package com.almaraz_john.chat_online.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MessageDTO {
    private UUID id;
    private UUID fromUserID;
    private String content;
    private UUID conversationID;
}
