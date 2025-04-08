package com.almaraz_john.chat_online.application.ports.input;

import com.almaraz_john.chat_online.application.command.message.SendMessageCommand;
import com.almaraz_john.chat_online.application.dto.MessageDTO;

public interface MessageService {
    MessageDTO sendMessage(SendMessageCommand command);
    MessageDTO receiveMessage();
}
