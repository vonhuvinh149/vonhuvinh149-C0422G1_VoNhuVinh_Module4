package com.exercise.service;

import com.exercise.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void create(Music music);

    Music findId(int id);

    void update(Music music);

    void delete(int id);
}

