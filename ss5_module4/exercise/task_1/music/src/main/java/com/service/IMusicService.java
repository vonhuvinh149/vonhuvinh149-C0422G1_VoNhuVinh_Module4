package com.service;

import com.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll(String name);

    Music findById(int id);

    void create(Music listen);

    void update(int id, Music listen);

    void delete(int id);

}
