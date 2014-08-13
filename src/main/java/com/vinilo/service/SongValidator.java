package com.vinilo.service;

import com.vinilo.model.Song;
import com.vinilo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class SongValidator {

    @Autowired
    private SongRepository songRepository;  

    public void validate(Song song, Errors errors) {
        //name
        if (songRepository.searchByName(song.getName()) != null) {
            errors.rejectValue("name", "Duplicate");
        }
    }
}
