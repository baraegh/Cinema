package com.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.models.Session;
import com.cinema.services.SessionService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/admin/panel/sessions")
public class SessionController {
    private final SessionService    sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/save")
    public String saveSession(@ModelAttribute Session session) {
        sessionService.save(session);

        return "";
    }
    
    @GetMapping
    public String getAllSessions(Model model) {
        model.addAttribute("sessions", sessionService.getAll());

        return "";
    }
    
}
