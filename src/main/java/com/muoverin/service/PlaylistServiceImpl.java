package com.muoverin.service;

import com.muoverin.model.Playlist;
import com.muoverin.repository.PlaylistRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Playlist> searchAll() {
        return playlistRepository.searchAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Playlist searchById(long id) {
        return playlistRepository.searchById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public void remove(Playlist playlist) {
        playlistRepository.remove(playlist);
    }
}
