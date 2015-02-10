package com.muoverin.service;

import com.muoverin.model.Album;
import com.muoverin.model.Artist;
import com.muoverin.repository.AlbumRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class AlbumValidator {

    @Autowired
    private AlbumRepository albumRepository;

    public void validate(Album album, Errors errors) {

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
