package com.controller;

import com.model.Music;
import com.model.MusicForm;
import com.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/music")
@PropertySource("classpath:upload_file.properties")
public class MusicController {
    @Autowired
    private IMusicService listenService;

    @GetMapping("/")
    public String index(@RequestParam(required = false,defaultValue = "") String listenName, Model model) {
        List<Music> listenList = listenService.findAll(listenName);
        model.addAttribute("listenForm", listenList);
        return "/list";
    }

    @GetMapping("showCreate")
    public String showCreate(Model model) {
        model.addAttribute("listenForm", new Music());
        return "/create";
    }

    @Value("${file-upload}")
    private String fileUpload;

    @PostMapping(value = "/create", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ModelAndView saveProduct(@ModelAttribute MusicForm musicForm) {
        MultipartFile multipartFile = musicForm.getPathFile();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(musicForm.getPathFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Music listen = new Music(musicForm.getListenName(), musicForm.getArtist(),
                musicForm.getCategory(), fileName);
        listenService.create(listen);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("listenForm", musicForm);
        modelAndView.addObject("mess", "Thêm mới thành công!");
        return modelAndView;
    }

    @GetMapping("showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Music listen = listenService.findById(id);
        model.addAttribute("listenForm", listen);
        return "/update";
    }

    @PostMapping("edit/{id}")
    public String edit(@ModelAttribute Music listen,
                       @PathVariable int id,
                       RedirectAttributes redirectAttributes) {
        listenService.update(id, listen);
        redirectAttributes.addFlashAttribute("mess", "update thành công");
        return "redirect:/music/showList";
    }

    @PostMapping("delete")
    public String delete(@RequestParam int id,
                         RedirectAttributes redirectAttributes) {
        listenService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Delete thành công");
        return "redirect:/music/showList";
    }
}
