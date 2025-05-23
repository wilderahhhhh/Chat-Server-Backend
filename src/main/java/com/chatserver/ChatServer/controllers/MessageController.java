package com.chatserver.ChatServer.controllers;


import com.chatserver.ChatServer.models.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public MessageModel sendMessage(@DestinationVariable String roomId, MessageModel message) {
        logger.info("Message received in room {}: {}", roomId, message);
        return message;
    }
}
