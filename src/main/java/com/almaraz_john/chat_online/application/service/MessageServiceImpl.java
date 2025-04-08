package com.almaraz_john.chat_online.application.service;

import com.almaraz_john.chat_online.application.command.message.SendMessageCommand;
import com.almaraz_john.chat_online.application.dto.MessageDTO;
import com.almaraz_john.chat_online.application.mapper.MessageMapper;
import com.almaraz_john.chat_online.application.ports.input.MessageService;
import com.almaraz_john.chat_online.application.ports.output.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository repository;
    private final MessageMapper mapper;

    @Override
    public MessageDTO sendMessage(SendMessageCommand command) {
        MessageDTO messageDTO = command.getMessageDTO();

        return null;
    }

    @Override
    public MessageDTO receiveMessage() {
        return null;
    }
}
