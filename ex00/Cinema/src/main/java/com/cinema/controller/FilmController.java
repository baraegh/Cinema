package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.models.Film;
import com.cinema.services.FilmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin/panel/films")
public class FilmController {
    
    private final FilmService   filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping("/save")
    public String saveFilm(@ModelAttribute Film film) {
        filmService.save(film);
        return "";
    }
    

    @GetMapping
    public String getAllFilms(Model model) {
        model.addAttribute("films", filmService.getAll());

        return "";
    }
    
}
