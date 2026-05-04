package com.cinema.repositories;

import java.util.List;
import com.cinema.models.ChatMessage;

public interface ChatRepository extends CrudeRepository<ChatMessage> {
    public List<ChatMessage> findLast20ByFilmId(Long filmId);
}
