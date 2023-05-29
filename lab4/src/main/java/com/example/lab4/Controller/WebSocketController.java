package com.example.lab4.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    private List<String> messagelist = new ArrayList<String>();
    @MessageMapping("/updateData")
    public void updateData(String data) {
        messagelist.add(data);
        messagingTemplate.convertAndSend("/topic/data", messagelist);
    }

}
