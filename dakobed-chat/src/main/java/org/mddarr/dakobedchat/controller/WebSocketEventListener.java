package org.mddarr.dakobedchat.controller;

import org.mddarr.dakobedchat.models.ChatMessage;
import org.mddarr.dakobedchat.models.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

import java.awt.*;

@Component
public class WebSocketEventListener {

    @Autowired
    private SimpMessageSendingOperations sendingOperations;

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
    @EventListener
    public void handlewebSocketConnectListener(final SessionConnectedEvent event){
        logger.info("bing bong bing. we Have a ");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(final SessionConnectedEvent event){
        final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        final String username = (String) headerAccessor.getSessionAttributes().get("username");
        final ChatMessage chatMessage = ChatMessage.builder()
                .type(MessageType.DISCONNECT)
                .sender(username)
                .build();
        sendingOperations.convertAndSend("/topic/public/", chatMessage);
    }

}
