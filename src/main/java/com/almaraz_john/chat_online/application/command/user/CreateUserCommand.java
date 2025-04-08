package com.almaraz_john.chat_online.application.command.user;

import com.almaraz_john.chat_online.application.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserCommand {
    private UserDTO userDTO;
}
