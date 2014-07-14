package com.vinilo.service;

import com.vinilo.model.Album;
import com.vinilo.repository.AlbumRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    
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
        return albumRepository.save(album);
    }

    @Override
    public void remove(Album album) {
        albumRepository.remove(album);
    }

    @Override
    public List<Album> searchByArtist(long id_artist) {
        return albumRepository.searchByArtist(id_artist);
    }
    
}
