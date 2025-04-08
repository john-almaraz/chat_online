package com.almaraz_john.chat_online.application.ports.output;

import com.almaraz_john.chat_online.domain.aggregate.User;
import com.almaraz_john.chat_online.domain.vo.ID;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User createUser(User user);
    Optional<User> getUserByID(ID userID);
    List<User> getUsersByIDs(List<ID> userIDs);

}
