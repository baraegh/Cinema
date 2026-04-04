package com.cinema.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.models.Hall;
import com.cinema.repositories.HallRepositoryEntityManagerImpl;

@Service
public class HallService {
    
    private final HallRepositoryEntityManagerImpl hallRepository;

    public HallService(HallRepositoryEntityManagerImpl hallRepository) {
        this.hallRepository = hallRepository;
    }

    public Hall save(Hall hall) {
        return hallRepository.save(hall);
    }

    public List<Hall> getAll() {
        return hallRepository.findAll();
    }
}
