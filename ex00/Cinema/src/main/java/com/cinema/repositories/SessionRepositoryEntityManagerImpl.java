package com.cinema.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cinema.models.Session;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class SessionRepositoryEntityManagerImpl implements SessionRepository {

    @PersistenceContext
    EntityManager   em;

    @Override
    @Transactional
    public Session save(Session entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Session findById(Long id) {
        return em.find(Session.class, id);
    }

    @Override
    @Transactional
    public Session update(Session entity) {
        em.persist(entity);
        return  entity;
    }

    @Override
    public void delete(Long id) {
        em.remove(findById(id));
    }

    @Override
    public List<Session> findAll() {
        return em.createQuery("FROM Session", Session.class)
                .getResultList();
    }
    
}
