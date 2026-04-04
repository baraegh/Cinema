package com.cinema.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cinema.models.Film;
import com.cinema.repositories.FilmRepositoryEntityManagerImpl;

@Service
public class FilmService {
    private final FilmRepositoryEntityManagerImpl filmRepository;

    public FilmService(FilmRepositoryEntityManagerImpl filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public List<Film> getAll() {
        return filmRepository.findAll();
    }
}
