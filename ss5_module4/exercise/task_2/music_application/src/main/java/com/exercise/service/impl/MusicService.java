package com.exercise.service.impl;

import com.exercise.model.Music;
import com.exercise.repository.IMusicRepository;
import com.exercise.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public void create(Music music) {
        iMusicRepository.create(music);
    }

    @Override
    public Music findId(int id) {
        return iMusicRepository.findId(id);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music);
    }

    @Override
    public void delete(int id) {
        iMusicRepository.delete(id);
    }
}
