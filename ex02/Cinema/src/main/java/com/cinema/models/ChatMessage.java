package com.cinema.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long            id;

    @Column(name = "film_id")
    private Long            filmId;

    @Column(name = "user_id")
    private Long            userId;

    @Column(name = "msg")
    private String          msg;

    @Column(name = "date_time")
    private LocalDateTime   dateTime;

    @Column(name = "ip_address")
    private String          ipAddress;


    public ChatMessage() {}

    public ChatMessage(Long id, Long filmId, Long userId, String msg, LocalDateTime dateTime, String ipAddress) {
        this.id = id;
        this.filmId = filmId;
        this.userId = userId;
        this.msg = msg;
        this.dateTime = dateTime;
        this.ipAddress = ipAddress;
    }

    public ChatMessage(Long filmId, Long userId, String msg, LocalDateTime dateTime, String ipAddress) {
        this.filmId = filmId;
        this.userId = userId;
        this.msg = msg;
        this.dateTime = dateTime;
        this.ipAddress = ipAddress;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFilmId() {
        return this.filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

}
