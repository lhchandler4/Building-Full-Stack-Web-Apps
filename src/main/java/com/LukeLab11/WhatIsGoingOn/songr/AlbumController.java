package com.LukeLab11.WhatIsGoingOn.songr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value="details/{id}",method = RequestMethod.GET)
    public String getOneAlbumDetail(@PathVariable Long id,Model m){
        Album a = albumRepository.findById(id).get();
        m.addAttribute("albumdetail",a);
        m.addAttribute("newsong",new Song());
        m.addAttribute("id", id);
        return "AlbumDetailsHTML";
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

    @PostMapping("AlbumDetailsHTML/{id}")
    public String getOneAlbumDetail(@PathVariable Long id,@RequestParam String title,@RequestParam int length,@RequestParam int trackNumber){
        Album lookingAt = albumRepository.findById(id).get();
        if(!lookingAt.songs.isEmpty()) {
            Song newSong= new Song(title,length,trackNumber,lookingAt);
            songRepository.save(newSong);
            int totalLength = 0;
            for (Song presentlyViewing : lookingAt.songs) {
                totalLength = totalLength + presentlyViewing.length;
            }
            lookingAt.setLength(totalLength+newSong.length);
            lookingAt.setSongCount(lookingAt.songs.size()+1);
        }
        else {
            Song newSong= new Song(title,length,trackNumber,lookingAt);
            songRepository.save(newSong);
            lookingAt.setLength(newSong.length);
            lookingAt.setSongCount(1);
        }

        albumRepository.save(lookingAt);
        return "redirect:/details/{id}";
    }
}
