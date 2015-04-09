package com.muoverin.service;

import com.muoverin.model.Song;
import com.muoverin.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class SongValidator implements Validator {

    @Autowired
    private SongRepository songRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        if (songRepository.searchByNameAndAlbum(song.getName(), song.getAlbum().getId_album()) != null) {
            errors.rejectValue("name", "Duplicate");
        }
    }
}
