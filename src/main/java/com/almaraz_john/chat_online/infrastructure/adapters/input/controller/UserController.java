package com.almaraz_john.chat_online.infrastructure.adapters.input.controller;

import com.almaraz_john.chat_online.application.command.user.CreateUserCommand;
import com.almaraz_john.chat_online.application.command.user.GetUserByIdCommand;
import com.almaraz_john.chat_online.application.dto.UserDTO;
import com.almaraz_john.chat_online.application.ports.input.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserCommand command){
        return new ResponseEntity<>(service.createUser(command), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable UUID userId){
        GetUserByIdCommand command = new GetUserByIdCommand(userId);

        return ResponseEntity.ok(service.getUserByID(command));
    }

}
