package com.almaraz_john.chat_online.application.command.conversation;

import com.almaraz_john.chat_online.application.dto.ConversationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateConversationCommand {
    private ConversationDTO conversationDTO;
}
