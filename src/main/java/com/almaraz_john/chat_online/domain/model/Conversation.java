package com.almaraz_john.chat_online.domain.model;

import com.almaraz_john.chat_online.domain.aggregate.User;
import com.almaraz_john.chat_online.domain.vo.ID;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Conversation {
    private ID id;
    private List<User> userList;
    private List<Message> messageList;
}
