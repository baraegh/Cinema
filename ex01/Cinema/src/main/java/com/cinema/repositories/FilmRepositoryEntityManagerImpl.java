package com.cinema.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cinema.models.Film;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class FilmRepositoryEntityManagerImpl implements FilmRepository{

    @PersistenceContext
    private EntityManager   em;

    @Override
    @Transactional
    public Film save(Film entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Film findById(Long id) {
        return em.find(Film.class, id);
    }

    @Override
    @Transactional
    public Film update(Film entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        em.remove(findById(id));
    }

    @Override
    public List<Film> findAll() {
        return em.createQuery("From Film", Film.class)
                .getResultList();
    }
    
}
