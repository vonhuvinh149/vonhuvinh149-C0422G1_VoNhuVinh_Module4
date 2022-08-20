package com.exercise.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "ten")
    private String name;
    @Column(name = "tac_gia")
    private String musician;
    @Column(name = "the_loai")
    private String typeOfMusic;
    @Column(name = "link")
    private String link;

    public Music(int id, String name, String musician, String typeOfMusic, String link) {
        this.id = id;
        this.name = name;
        this.musician = musician;
        this.typeOfMusic = typeOfMusic;
        this.link = link;
    }

    public Music() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getTypeOfMusic() {
        return typeOfMusic;
    }

    public void setTypeOfMusic(String typeOfMusic) {
        this.typeOfMusic = typeOfMusic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
