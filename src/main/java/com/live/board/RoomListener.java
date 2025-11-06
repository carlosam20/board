package com.live.board;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RoomListener implements ApplicationListener<RoomEvent> {
    @Override
    public void onApplicationEvent(RoomEvent event) {
        log.info("Received spring custom event - {}", event.getMessage());
    }
}

