package com.almaraz_john.chat_online.application.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class ConversationDTO {
    private List<UUID> userIDs;
}
