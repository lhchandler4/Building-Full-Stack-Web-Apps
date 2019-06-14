package com.LukeLab11.WhatIsGoingOn.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;

    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        Iterable<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "SongHTML";
    }

    @GetMapping("/songs/new")
    public String getAddSongForm() {
        return "SongFormHTML";
    }

    @PostMapping("/songs")
    public RedirectView addSong(@RequestParam String title, @RequestParam int length, @RequestParam int trackNumber, @RequestParam Album album) {
        Song song = new Song(title, length, trackNumber, album);
        songRepository.save(song);
        return new RedirectView("/songs");
    }
}
