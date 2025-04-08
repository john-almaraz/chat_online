package com.almaraz_john.chat_online.application.command.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class GetUserByIdCommand {
    private UUID id;
}
