package com.almaraz_john.chat_online.application.service;

import com.almaraz_john.chat_online.application.command.user.CreateUserCommand;
import com.almaraz_john.chat_online.application.command.user.GetUserByIdCommand;
import com.almaraz_john.chat_online.application.dto.UserDTO;
import com.almaraz_john.chat_online.application.mapper.UserMapper;
import com.almaraz_john.chat_online.application.ports.input.UserService;
import com.almaraz_john.chat_online.application.ports.output.UserRepository;
import com.almaraz_john.chat_online.domain.aggregate.User;
import com.almaraz_john.chat_online.domain.exception.UserNotFoundException;
import com.almaraz_john.chat_online.domain.model.Conversation;
import com.almaraz_john.chat_online.domain.vo.ID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDTO createUser(CreateUserCommand command) {
        UserDTO userDTO = command.getUserDTO();
        List<Conversation> conversationDTOList= new ArrayList<>();

        User user = repository.createUser(
                new User(
                    ID.create(),
                    userDTO.getUsername(),
                    conversationDTOList
                )
        );

        return mapper.toDTO(user);
    }

    @Override
    public UserDTO getUserByID(GetUserByIdCommand command) {
        UUID userId = command.getId();

        User user = repository.getUserByID(ID.of(userId)).orElseThrow(
                ()-> new UserNotFoundException("User with ID: " +userId+ " not found.")
        );

        return mapper.toDTO(user);
    }
}
