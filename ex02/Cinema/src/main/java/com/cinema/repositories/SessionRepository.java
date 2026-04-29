package com.cinema.repositories;

import java.util.List;

import com.cinema.models.Session;

public interface SessionRepository extends CrudeRepository<Session> {
    List<Session> findByFileName(String filmName);
}
