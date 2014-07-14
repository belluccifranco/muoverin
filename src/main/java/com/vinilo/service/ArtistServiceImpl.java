package com.vinilo.service;

import com.vinilo.model.Artist;
import com.vinilo.repository.ArtistRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtistServiceImpl implements ArtistService {
    
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Artist> searchAll() {
        return artistRepository.searchAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Artist searchById(long id) {
        return artistRepository.searchById(id);
    }

    @Override
    @Transactional
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public void remove(Artist artist) {
        artistRepository.remove(artist);
    }
    
}
