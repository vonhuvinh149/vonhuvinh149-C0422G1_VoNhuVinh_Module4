package com.codegym.controller;

import com.codegym.dto.MusicDto;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("/")
    public String list(Model model) {
        List<Music> musicList = this.musicService.findAll();
        model.addAttribute("musics", musicList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new MusicDto());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("music") @Valid MusicDto music, BindingResult bindingResult) {

        Music myMusic = new Music();
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        BeanUtils.copyProperties(music, myMusic);
        this.musicService.save(myMusic);

        return "redirect:/";
    }
}
