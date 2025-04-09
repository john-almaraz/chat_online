package com.almaraz_john.chat_online.infrastructure.adapters.input.controller;

import com.almaraz_john.chat_online.application.command.conversation.CreateConversationCommand;
import com.almaraz_john.chat_online.application.command.conversation.DeleteConversationCommand;
import com.almaraz_john.chat_online.application.command.conversation.GetAllConversationsFromUserCommand;
import com.almaraz_john.chat_online.application.command.conversation.GetConversationByIdCommand;
import com.almaraz_john.chat_online.application.dto.ConversationDTO;
import com.almaraz_john.chat_online.application.ports.input.ConversationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/conversation")
@AllArgsConstructor
public class ConversationController {

    private final ConversationService service;

    @PostMapping
    public ResponseEntity<ConversationDTO> createConversation(@RequestBody CreateConversationCommand command){
        return new ResponseEntity<>(service.createConversation(command), HttpStatus.CREATED);
    }

    @GetMapping("/{conversationId}")
    public ResponseEntity<ConversationDTO> getConversationByID(@PathVariable UUID conversationId){
        GetConversationByIdCommand command = new GetConversationByIdCommand(conversationId);

        return ResponseEntity.ok(service.getConversationByID(command));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ConversationDTO>> getAllConversationFromUser(@PathVariable UUID userId){
        GetAllConversationsFromUserCommand command = new GetAllConversationsFromUserCommand(userId);

        return ResponseEntity.ok(service.getAllConversationsFromUser(command));
    }

    @DeleteMapping("/{conversationId}")
    public ResponseEntity<Void> deleteConversation(@PathVariable UUID conversationId){
        DeleteConversationCommand command = new DeleteConversationCommand(conversationId);
        service.deleteConversation(command);

        return ResponseEntity.noContent().build();
    }

}
