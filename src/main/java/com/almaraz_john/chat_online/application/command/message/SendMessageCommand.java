package com.almaraz_john.chat_online.application.command.message;

import com.almaraz_john.chat_online.application.dto.MessageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SendMessageCommand {
    private MessageDTO messageDTO;
}
