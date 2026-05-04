package com.cinema.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.models.ChatMessage;
import com.cinema.repositories.ChatRepository;

@Service
public class ChatService {
    private final ChatRepository    chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }
    
    public ChatMessage save(ChatMessage message) {
        return chatRepository.save(message);
    }

    public ChatMessage getById(Long id) {
        return chatRepository.findById(id);
    }

    public List<ChatMessage> getAll() {
        return chatRepository.findAll();
    }

    public List<ChatMessage> getLast20ByFilmId(Long filmId) {
        return chatRepository.findLast20ByFilmId(filmId);
    }

    public ChatMessage update(ChatMessage message) {
        return chatRepository.update(message);
    }

    public void delete(Long id) {
        chatRepository.delete(id);
    }
}
