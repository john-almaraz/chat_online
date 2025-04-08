package com.almaraz_john.chat_online.application.ports.output;

import com.almaraz_john.chat_online.domain.model.Message;

public interface MessageRepository {
    Message sendMessage(Message message);
    Message receiveMessage();
}
