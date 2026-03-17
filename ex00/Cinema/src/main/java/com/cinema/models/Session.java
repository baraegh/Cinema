package com.cinema.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sessions")
public class Session {
    @Id @GeneratedValue
    private Long            id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film            film;

    @ManyToOne
    @JoinColumn(name = "hall_id")
    private Hall            hall;

    @Column(name = "date_time")
    private LocalDateTime   dateTime;

    @Column(name = "ticket_price")
    private double          ticketPrice;

    public Session() {
    }

    public Session(Long id, Film film, Hall hall, LocalDateTime dateTime, double ticketPrice) {
        this.id = id;
        this.film = film;
        this.hall = hall;
        this.dateTime = dateTime;
        this.ticketPrice = ticketPrice;
    }

    public Session(Film film, Hall hall, LocalDateTime dateTime, double ticketPrice) {
        this.film = film;
        this.hall = hall;
        this.dateTime = dateTime;
        this.ticketPrice = ticketPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    
}
