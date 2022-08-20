package com.exercise.repository;

import com.exercise.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void create(Music music);

    void update(Music music);

    Music findId(int id);

    void delete(int id);
}
