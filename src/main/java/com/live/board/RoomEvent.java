package com.live.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RoomEvent {
    private String message;

    public RoomEvent(Object source, String message) {
        super();
        this.message = message;
    }
}
