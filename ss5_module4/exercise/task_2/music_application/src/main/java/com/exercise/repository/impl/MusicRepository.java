package com.exercise.repository.impl;

import com.exercise.model.Music;
import com.exercise.repository.BaseRepository;
import com.exercise.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    @Override
    public List<Music> findAll() {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.createQuery("select m from Music m", Music.class);
        return typedQuery.getResultList();
    }

    @Override
    public void create(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public Music findId(int id) {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.createQuery("select m from Music m where m.id = :idMusic", Music.class);
        typedQuery.setParameter("idMusic", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove((BaseRepository.entityManager.find(Music.class, id)));
        entityTransaction.commit();
    }
}
