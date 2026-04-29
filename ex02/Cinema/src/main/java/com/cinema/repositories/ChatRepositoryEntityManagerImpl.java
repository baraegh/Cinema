package com.cinema.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cinema.models.ChatMessage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ChatRepositoryEntityManagerImpl implements ChatRepository {

    @PersistenceContext
    private EntityManager   em;

    @Override
    @Transactional
    public ChatMessage save(ChatMessage entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public ChatMessage findById(Long id) {
        return em.find(ChatMessage.class, id);
    }

    @Override
    @Transactional
    public ChatMessage update(ChatMessage entity) {
        em.persist(entity);
        return entity;
    }

    @Override
    public void delete(Long id) {
        em.remove(findById(id));
    }

    @Override
    public List<ChatMessage> findAll() {
        return em.createQuery("From ChatMessage", ChatMessage.class)
                .getResultList();
    }

    @Override
    public List<ChatMessage> findLast20ByFilmId() {
        return em.createQuery("From ChatMessage order by dateTime desc", ChatMessage.class)
                .setMaxResults(20)
                .getResultList();
    }
    
}
