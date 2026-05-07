package com.cinema.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cinema.models.Avatar;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class AvatarRepoImp implements AvatarRepository {
    
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Avatar save(Avatar entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public Avatar findById(Long id) {
        return em.find(Avatar.class, id);
    }

    @Override
    public Avatar update(Avatar entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(Long id) {
        Avatar avatar = em.find(Avatar.class, id);
        if (avatar != null) {
            em.remove(avatar);
        }
    }

    @Override
    public List<Avatar> findAll() {
        return em.createQuery("SELECT a FROM Avatar a", Avatar.class).getResultList();
    }

    @Override
    public List<Avatar> findByUserIdAndFilmId(String userId, Long filmId) {
        return em.createQuery("SELECT a FROM Avatar a WHERE a.userId = :userId AND a.filmId = :filmId", Avatar.class)
                .setParameter("userId", userId)
                .setParameter("filmId", filmId)
                .getResultList();
    }
}
