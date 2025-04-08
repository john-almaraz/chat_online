package com.almaraz_john.chat_online.domain.model;

import com.almaraz_john.chat_online.domain.aggregate.User;
import com.almaraz_john.chat_online.domain.vo.ID;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Message {
    private ID id;
    private User fromUser;
    private String content;
    private Conversation conversation;
    private Instant timeStamp;
}
