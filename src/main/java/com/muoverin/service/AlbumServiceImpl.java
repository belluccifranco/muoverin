package com.muoverin.service;

import com.muoverin.exception.BusinessValidationException;
import com.muoverin.model.Album;
import com.muoverin.repository.AlbumRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    
    @Autowired
    private AlbumValidator albumValidator;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Album> searchAll() {
        return albumRepository.searchAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Album searchById(long id) {
        return albumRepository.searchById(id);
    }

    @Override
    @Transactional
    public Album save(Album album) {
        BindingResult result = new BeanPropertyBindingResult(album, "album");        
        
        albumValidator.validate(album, result);
        if (result.hasErrors()) {
            throw new BusinessValidationException(result);
        }
        
        return albumRepository.save(album);
    }

    @Override
    public void remove(Album album) {
        albumRepository.remove(album);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Album> searchByArtists(List<Long> artists_id) {
        return albumRepository.searchByArtists(artists_id);
    }

    @Override
    @Transactional(readOnly = true)
    public Album searchByName(String name) {
        return albumRepository.searchByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Album searchByNameAndArtists(String name, List<Long> artists_id) {
        return albumRepository.searchByNameAndArtists(name, artists_id);
    }
}
