package com.muoverin.service;

import com.muoverin.model.Album;
import com.muoverin.model.Artist;
import com.muoverin.repository.AlbumRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class AlbumValidator implements Validator {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Album.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Album album = (Album) target;
        if (album.getArtists().isEmpty()) {
            errors.rejectValue("artists", "Required");
        } else {
            List<Long> artists_id = new ArrayList<>();
            for (Artist artist : album.getArtists()) {
                artists_id.add(artist.getId_artist());
            }
            if (albumRepository.searchByNameAndArtists(album.getName(), artists_id) != null) {
                errors.rejectValue("name", "Duplicate");
            }
        }
    }
}
