package com.robin.sbwebsocket01.controller;

import com.robin.sbwebsocket01.bean.Chat;
import com.robin.sbwebsocket01.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Description
 * @Author Robin
 * @Date 2020/4/12 18:54
 */
@RestController
public class GreetingController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    //群聊方式1
//    @MessageMapping("/hello")
//    @SendTo("/topic/greetings")
//    public Message greeting(Message message) {
//        return message;
//    }

    //群聊方式2
    @MessageMapping("/hello")
    public void greeting2(Message message) {
        simpMessagingTemplate.convertAndSend("/topic/greetings",message);
    }

    //单聊,点对点（一对一）聊天
    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat) {
        chat.setFrom(principal.getName());
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(),"/queue/chat",chat);
    }

}
