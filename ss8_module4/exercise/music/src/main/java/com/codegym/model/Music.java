package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdMusic;
    @Column(name = "music_name")
    private String musicName;
    private String singer ;
    private String category;

    public Music(int idMusic, String musicName, String singer, String category) {
        IdMusic = idMusic;
        this.musicName = musicName;
        this.singer = singer;
        this.category = category;
    }

    public Music() {
    }

    public int getIdMusic() {
        return IdMusic;
    }

    public void setIdMusic(int idMusic) {
        IdMusic = idMusic;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
