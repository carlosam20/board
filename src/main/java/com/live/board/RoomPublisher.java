package com.live.board;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.context.ApplicationEventPublisher;

public class RoomPublisher {
    private ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(final String message) {
        System.out.println("Publishing custom event. ");
        RoomEvent customSpringEvent = new RoomEvent(this, message);
        applicationEventPublisher.publishEvent(customSpringEvent);
    }

}
