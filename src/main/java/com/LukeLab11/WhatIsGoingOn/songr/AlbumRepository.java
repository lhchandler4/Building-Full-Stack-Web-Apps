package com.LukeLab11.WhatIsGoingOn.songr;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    public List<Album> findByTitle(String title);
}
