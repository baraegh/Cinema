package com.cinema.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cinema.models.Session;
import com.cinema.repositories.SessionRepository;

import com.cinema.dto.SessionDto;
import com.cinema.dto.FilmDto;

@Service
public class SessionService {
    private final SessionRepository  sesssionRepository;

    public SessionService(SessionRepository  sesssionRepository) {
        this.sesssionRepository = sesssionRepository;
    }

    public Session save(Session session) {
        return sesssionRepository.save(session);
    }

    public List<Session> getAll() {
        return sesssionRepository.findAll();
    }

    public List<SessionDto> searchByFilmName(String filmName) {
        List<Session> sessions = sesssionRepository.findByFileName(filmName);

        return sessions.stream()
            .map(this::toSessionDto)
            .collect(Collectors.toList());
    }

    private SessionDto toSessionDto(Session session) {
        FilmDto filmDto = session.getFilm() != null ? 
            new FilmDto(
                session.getFilm().getTitle(),
                session.getFilm().getPosterUrl()
            )
        : null ;

        return new SessionDto(session.getId(), session.getFormattedDateTime(), filmDto);
    }
}
