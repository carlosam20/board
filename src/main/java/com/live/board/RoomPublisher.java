package com.live.board;

import org.springframework.context.ApplicationEventPublisher;

public record RoomPublisher(ApplicationEventPublisher applicationEventPublisher) {

    public void publishCustomEvent(final String message) {
        System.out.println("Publishing custom event. ");
        RoomEvent customSpringEvent = new RoomEvent(this.applicationEventPublisher, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

}
