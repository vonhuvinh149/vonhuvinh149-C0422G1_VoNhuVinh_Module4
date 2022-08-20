package com.repository.impl;

import com.model.Music;
import com.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepositoryImpl implements IMusicRepository {
    private  final String FIND_ALL = "select S from Music S where S.MusicName like :name";
    private final String FIND_BY_ID = "select s from Music as s where s.id = :id";

    @Override
    public List<Music> findAll(String name) {
        TypedQuery<Music> typedQuery = BaseRepository.entityManager.
                createQuery(FIND_ALL, Music.class);
        typedQuery.setParameter("name", "%" + name + "%");
        return typedQuery.getResultList();
    }

    @Override
    public Music findById(int id) {
        TypedQuery<Music> query = BaseRepository.entityManager.createQuery
                (FIND_BY_ID, Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void create(Music listen) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(listen);
        entityTransaction.commit();
    }

    @Override
    public void update(int id, Music listen) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(listen);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Music.class, id));
        entityTransaction.commit();
    }

}
