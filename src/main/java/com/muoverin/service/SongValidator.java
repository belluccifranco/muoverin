package com.muoverin.service;

import com.muoverin.model.Song;
import com.muoverin.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class SongValidator {

    @Autowired
    private SongRepository songRepository;  

    public void validate(Song song, Errors errors) {
        
        if (songRepository.searchByNameAndAlbum(song.getName(), song.getAlbum().getId_album()) != null) {
            errors.rejectValue("name", "Duplicate");
        }
    }
}
