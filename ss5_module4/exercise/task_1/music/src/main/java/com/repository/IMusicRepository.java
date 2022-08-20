package com.repository;

import com.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll(String name);

    Music findById(int id);

    void create(Music listen);

    void update(int id, Music listen);

    void delete(int id);

}
