package com.almaraz_john.chat_online.application.service;

import com.almaraz_john.chat_online.application.command.conversation.CreateConversationCommand;
import com.almaraz_john.chat_online.application.command.conversation.DeleteConversationCommand;
import com.almaraz_john.chat_online.application.command.conversation.GetAllConversationsFromUserCommand;
import com.almaraz_john.chat_online.application.command.conversation.GetConversationByIdCommand;
import com.almaraz_john.chat_online.application.dto.ConversationDTO;
import com.almaraz_john.chat_online.application.mapper.ConversationMapper;
import com.almaraz_john.chat_online.application.ports.input.ConversationService;
import com.almaraz_john.chat_online.application.ports.output.ConversationRepository;
import com.almaraz_john.chat_online.application.ports.output.UserRepository;
import com.almaraz_john.chat_online.common.mapper.IdMapper;
import com.almaraz_john.chat_online.domain.aggregate.User;
import com.almaraz_john.chat_online.domain.exception.ConversationNotFoundException;
import com.almaraz_john.chat_online.domain.exception.UserNotFoundException;
import com.almaraz_john.chat_online.domain.model.Conversation;
import com.almaraz_john.chat_online.domain.model.Message;
import com.almaraz_john.chat_online.domain.vo.ID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConversationServiceImpl implements ConversationService {

    private final ConversationRepository conversationRepository;
    private final ConversationMapper conversationMapper;
    private final UserRepository userRepository;
    private final IdMapper idMapper;

    @Override
    public ConversationDTO createConversation(CreateConversationCommand command) {
        ConversationDTO conversationDTO = command.getConversationDTO();
        List<ID> userIDs = idMapper.listUuidToID(conversationDTO.getUserIDs());

        List<Message> messageList = new ArrayList<>();
        List<User> userList = userRepository.getUsersByIDs(userIDs);

        if (userList.size() < 2) {
            throw new UserNotFoundException("it cannot create this conversation because one or more users not found, " +
                    "and one conversation must have at least 2 users");
        }

        Conversation conversation = conversationRepository.createConversation(
                new Conversation(
                    ID.create(),
                    userList,
                    messageList
                )
        );

        return conversationMapper.toDTO(conversation);
    }

    @Override
    public ConversationDTO getConversationByID(GetConversationByIdCommand command) {
        UUID conversationID = command.getId();

        Conversation conversation = conversationRepository.getConversationByID(ID.of(conversationID)).orElseThrow(
                ()-> new ConversationNotFoundException("Conversation with ID: "+ conversationID + " not found.")
        );

        return conversationMapper.toDTO(conversation);
    }

    @Override
    public List<ConversationDTO> getAllConversationsFromUser(GetAllConversationsFromUserCommand command) {
        UUID userID = command.getUserID();

        List<Conversation> conversationList = conversationRepository.getAllConversationsFromUser(ID.of(userID));

        if(conversationList.isEmpty())
            throw new ConversationNotFoundException("User with ID: " + userID + " not have conversations.");

        return conversationMapper.toListDTO(conversationList);
    }

    @Override
    public void deleteConversation(DeleteConversationCommand command) {
        ID conversationID = ID.of(command.getId());

        if (conversationRepository.getConversationByID(conversationID).isEmpty())
            throw new ConversationNotFoundException("Conversation with ID: "+ conversationID.getValue() + " not found.");

        conversationRepository.deleteConversation(conversationID);
    }
}
