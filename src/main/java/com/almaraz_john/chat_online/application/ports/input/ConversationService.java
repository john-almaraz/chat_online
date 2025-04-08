package com.almaraz_john.chat_online.application.ports.input;

import com.almaraz_john.chat_online.application.command.conversation.CreateConversationCommand;
import com.almaraz_john.chat_online.application.command.conversation.DeleteConversationCommand;
import com.almaraz_john.chat_online.application.command.conversation.GetAllConversationsFromUserCommand;
import com.almaraz_john.chat_online.application.command.conversation.GetConversationByIdCommand;
import com.almaraz_john.chat_online.application.dto.ConversationDTO;

import java.util.List;

public interface ConversationService {
    ConversationDTO createConversation(CreateConversationCommand command);
    ConversationDTO getConversationByID(GetConversationByIdCommand command);
    List<ConversationDTO> getAllConversationsFromUser(GetAllConversationsFromUserCommand command);
    void deleteConversation(DeleteConversationCommand command);
}
