package com.cinema.controller;

import java.util.List;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cinema.models.ChatMessage;
import com.cinema.services.ChatService;

@Controller
@RequestMapping("/films")
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/{filmId}/chat/messages")
    @SendTo("/topic/{filmId}/messages")
    public ChatMessage sendToFilmRoom(@Payload ChatMessage message, @DestinationVariable long filmId) {
        message.setFilmId(filmId);
        chatService.save(message);
        return message;
    }

    @GetMapping("/{filmId}/chat")
    public String getChatPage(@PathVariable long filmId, Model model) {
        model.addAttribute("filmId", filmId);
        model.addAttribute("initialMessages", chatService.getLast20ByFilmId(filmId));

        return "films/messages";
    }

    @GetMapping("/{filmId}/messages")
    @ResponseBody
    public List<ChatMessage> getMessages(@PathVariable long filmId) {
        return chatService.getLast20ByFilmId(filmId);
    }

}
