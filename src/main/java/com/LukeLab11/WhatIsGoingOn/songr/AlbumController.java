package com.LukeLab11.WhatIsGoingOn.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model m) {
        Iterable<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "AlbumHTML";
    }

    @GetMapping("/albums/new")
    public String getAddAlbumForm() {
        return "AlbumFormHTML";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(@RequestParam String title, @RequestParam String artist, @RequestParam int songCount, @RequestParam int length, @RequestParam String imageUrl) {
        Album album = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }

//    @PostMapping("/albums")
//    public RedirectView addSong(@RequestParam String title, @RequestParam int length, @RequestParam int trackNumber, @RequestParam Album album) {
//        List<Song> findByTitle = albumRepository.findByTitle();
//        if(findByTitle.size() > 0) {
//            //                                     languagesWithThatName[0]
//            Song song = new Song(title, title(0));
//            songRepository.save(song);
//            return new RedirectView("/albums");
//        } else {
//            Song song = new Song(text, new Language(language));
//            songRepository.save(song);
//            return new RedirectView("/album");
//        }
//    }
}
