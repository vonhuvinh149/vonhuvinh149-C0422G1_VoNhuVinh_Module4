package com.model;

import javax.persistence.*;

@Entity
@Table(name = "list_music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "list_name")
    private String MusicName;
    private String artist;
    private String category;

    @Column(name = "path_file")
    private String pathFile;

    public Music() {
    }

    public Music(int id, String listenName, String artist, String category, String pathFile) {
        this.id = id;
        this.MusicName = listenName;
        this.artist = artist;
        this.category = category;
        this.pathFile = pathFile;
    }

    public Music(String listenName, String artist, String category, String pathFile) {
        this.MusicName = listenName;
        this.artist = artist;
        this.category = category;
        this.pathFile = pathFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMusicName() {
        return MusicName;
    }

    public void setMusicName(String listenName) {
        this.MusicName = listenName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }
}
