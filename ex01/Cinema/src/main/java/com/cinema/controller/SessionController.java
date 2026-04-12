package com.cinema.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cinema.dto.SessionDto;
import com.cinema.services.SessionService;

@Controller
@RequestMapping("/sessions")
public class SessionController {
    private final SessionService    sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }
    

    @GetMapping("/search")
    @ResponseBody
    public List<SessionDto> searchByFileName(@RequestParam String filmName) {
        return sessionService.searchByFilmName(filmName);
    }
    
}
