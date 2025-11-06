package com.live.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class RoomEvent extends ApplicationEvent {
    private final String message;

    public RoomEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
