package com.service.impl;

import com.model.Music;
import com.repository.IMusicRepository;
import com.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements IMusicService {
    @Autowired
    private IMusicRepository iListenRepository;

    @Override
    public List<Music> findAll(String name) {
        return iListenRepository.findAll(name);
    }

    @Override
    public Music findById(int id) {
        return iListenRepository.findById(id);
    }

    @Override
    public void create(Music listen) {
        iListenRepository.create(listen);
    }

    @Override
    public void update(int id, Music listen) {
        iListenRepository.update(id,listen);
    }

    @Override
    public void delete(int id) {
        iListenRepository.delete(id);
    }
}
