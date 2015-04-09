package com.muoverin.service;

import com.muoverin.model.Artist;
import com.muoverin.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class ArtistValidator implements Validator {

    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Artist.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Artist artist = (Artist) target;
        if (artistRepository.searchByName(artist.getName()) != null) {
            errors.rejectValue("name", "Duplicate");
        }
    }
}
