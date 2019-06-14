package com.LukeLab11.WhatIsGoingOn.songr;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String artist;
    int songCount;
    int length;
    String imageUrl;

    public Album() {}
    public Album(String title, String artist, int songCount, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.length = length;
        this.imageUrl = imageUrl;
    }

    @OneToMany(mappedBy = "album")
    List<Song> songs;

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getArtist() {
        return this.artist;
    }

    public int getSongCount() {
        return this.songCount;
    }

    public double getLength() {
        return this.length;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public List<Song> getSongs() {
        return songs;
    }
}

