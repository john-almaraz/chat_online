package com.almaraz_john.chat_online.domain.aggregate;

import com.almaraz_john.chat_online.domain.model.Conversation;
import com.almaraz_john.chat_online.domain.vo.ID;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private ID id;
    private String username;
    private List<Conversation> conversationList;
}
