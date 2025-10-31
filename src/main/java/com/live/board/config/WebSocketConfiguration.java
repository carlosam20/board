package com.live.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // /portfolio is the HTTP URL for the endpoint to which a WebSocket (or SockJS)
        // client needs to connect for the WebSocket handshake
        registry.addEndpoint("/ws-editor")
        .setAllowedOriginPatterns("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // STOMP messages whose destination header begins with /app are routed to
        // @MessageMapping methods in @Controller classes

        registry.setApplicationDestinationPrefixes("/app");
        // Use the built-in message broker for subscriptions and broadcasting and
        // route messages whose destination header begins with /topic or /queue to the broker

        registry.enableSimpleBroker("/topic")
                .setHeartbeatValue(new long[]{10000, 20000});
    }
}
