package com.almaraz_john.chat_online.application.command.conversation;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class GetAllConversationsFromUserCommand {
    private UUID userID;
}
