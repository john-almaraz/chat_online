package com.almaraz_john.chat_online.domain.vo;

import com.almaraz_john.chat_online.domain.exception.InvalidIdFormatException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@EqualsAndHashCode
public final class ID {

    private final UUID value;

    private ID(UUID value) {
        if (value == null) {
            throw new InvalidIdFormatException("The identifier cannot be null");
        }
        this.value = value;
    }

    public static ID create() {
        return new ID(UUID.randomUUID());
    }

    public static ID of(UUID value) {
        return new ID(value);
    }
}
