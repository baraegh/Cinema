package com.cinema.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.models.Session;
import com.cinema.repositories.SessionRepositoryEntityManagerImpl;

@Service
public class SessionService {
    private final SessionRepositoryEntityManagerImpl  sesssionRepository;

    public SessionService(SessionRepositoryEntityManagerImpl  sesssionRepository) {
        this.sesssionRepository = sesssionRepository;
    }

    public Session save(Session session) {
        return sesssionRepository.save(session);
    }

    public List<Session> getAll() {
        return sesssionRepository.findAll();
    }
}
