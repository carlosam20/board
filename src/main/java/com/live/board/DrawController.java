package com.live.board;

import com.live.board.dto.DrawingEvent;
import com.sun.jdi.event.ExceptionEvent;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.awt.event.ActionEvent;


@Slf4j
@Controller
public class DrawController {

    @MessageMapping("/draw")
    @SendTo("/topic/board")
    public DrawingEvent broadcastDrawing(@Valid DrawingEvent event) {

        try{
            log.info("Received drawing event: {}", event);

        }catch (Exception e){
            log.error("Error on connection drawing: {}", event.toString(), e);
        }
        return event;
    }


    @MessageMapping("/draw/{roomId}")
    @SendTo("/topic/board/{roomId}")
    public DrawingEvent broadcastToRoom(@DestinationVariable String roomId, @Valid DrawingEvent event) {
        try{
//            RoomPublisher roomPublisher = new ();
            log.info("Room [{}] - Event: {}", roomId, event);
        }catch (Exception e){
            log.error("Error entering Room threw: {}",roomId,e);
        }

        return event;
    }
}
