package com.almaraz_john.chat_online.application.ports.input;

import com.almaraz_john.chat_online.application.command.user.CreateUserCommand;
import com.almaraz_john.chat_online.application.command.user.GetUserByIdCommand;
import com.almaraz_john.chat_online.application.dto.UserDTO;

public interface UserService {
    UserDTO createUser(CreateUserCommand command);
    UserDTO getUserByID(GetUserByIdCommand command);
}
