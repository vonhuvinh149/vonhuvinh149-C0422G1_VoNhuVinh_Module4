package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDto implements Validator {

    @NotBlank
    @Size(min = 1 , max = 800)
    @Pattern(regexp = "[A-Za-z ]+",message = "nhap sai dinh dang")
    private String musicName;

    @NotBlank
    @Size(min = 1 , max = 300)
    @Pattern(regexp = "[A-Za-z ]+",message = "nhap sai dinh dang")
    private String singer ;

    @NotBlank
    @Size(min = 1 , max = 1000)
    @Pattern(regexp = "[A-Za-z ]+[0-9, ]*",message = "nhap sai dinh dang")
    private String category;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    public MusicDto() {
    }

    public MusicDto(String musicName, String singer, String category) {
        this.musicName = musicName;
        this.singer = singer;
        this.category = category;
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

    @Override
    public void validate(Object target, Errors errors) {

    }
}
