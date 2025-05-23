package com.chatserver.ChatServer.models;

import java.util.UUID;

public record MessageModel(
        UUID roomId,
        UUID userId,
        String userName,
        String content,
        String timestamp
) {
    public static MessageModel create(UUID roomId, UUID userId, String userName, String content) {
        return new MessageModel(roomId, userId, userName, content, java.time.LocalDateTime.now().toString());
    }
}
