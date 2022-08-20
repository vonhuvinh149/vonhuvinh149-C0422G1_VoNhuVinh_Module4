package com.exercise.controller;

import com.exercise.model.Music;
import com.exercise.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String list(Model model) {
        List<Music> musicList = iMusicService.findAll();
        model.addAttribute("musicList", musicList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/saveCreate")
    public String save(@ModelAttribute Music music) {
        iMusicService.create(music);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, Model model) {
        Music music = iMusicService.findId(id);
        model.addAttribute("music", music);
        return "/update";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdate(@ModelAttribute Music music) {
        iMusicService.update(music);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        iMusicService.delete(id);
        return "redirect:/";
    }
}
