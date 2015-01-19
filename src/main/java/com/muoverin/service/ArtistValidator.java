package com.muoverin.service;

import com.muoverin.model.Artist;
import com.muoverin.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@Service
public class ArtistValidator {
    
    @Autowired
    private ArtistRepository artistRepository;
    
    public void validate(Artist artist, Errors errors) {
        
        if (artistRepository.searchByName(artist.getName()) != null) {
            errors.rejectValue("name", "Duplicate");
        }
    }
}
