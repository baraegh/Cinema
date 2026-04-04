package com.cinema.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cinema.models.Hall;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class HallRepositoryEntityManagerImpl implements HallRepository {

    @PersistenceContext
    EntityManager   em;

    @Override
    @Transactional
    public Hall save(Hall entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Hall findById(Long id) {
        return em.find(Hall.class, id);
    }

    @Override
    @Transactional
    public Hall update(Hall entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        em.remove(findById(id));
    }

    @Override
    public List<Hall> findAll() {
        return em.createQuery("FROM halls", Hall.class)
                .getResultList();
    }

}
