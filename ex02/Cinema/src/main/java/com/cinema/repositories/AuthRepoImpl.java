package com.cinema.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cinema.models.UserAuthentication;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class AuthRepoImpl implements AuthRepository{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UserAuthentication save(UserAuthentication entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public UserAuthentication findById(Long id) {
        return em.find(UserAuthentication.class, id);
    }

    @Override
    @Transactional
    public UserAuthentication update(UserAuthentication entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(Long id) {
        UserAuthentication auth = em.find(UserAuthentication.class, id);
        if (auth != null) {
            em.remove(auth);
        }
    }

    @Override
    public List<UserAuthentication> findAll() {
        return em.createQuery("SELECT ua FROM UserAuthentication ua", UserAuthentication.class)
                .getResultList();
    }

    @Override
    public List<UserAuthentication> findByUserId(String userId) {
        return em.createQuery("SELECT ua FROM UserAuthentication ua WHERE userId = :userId", UserAuthentication.class)
                .setParameter("userId", userId)
                .getResultList();
    }
    
}
