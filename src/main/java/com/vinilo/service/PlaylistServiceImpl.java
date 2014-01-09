package com.vinilo.service;

import com.vinilo.model.ListaReproduccion;
import com.vinilo.repository.PlaylistRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlist) {
        this.playlistRepository = playlist;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ListaReproduccion> searchAllPlaylists() {
        return playlistRepository.searchAllPlaylists();
    }

    @Override
    @Transactional(readOnly = true)
    public ListaReproduccion searchById(Long id) {
        return playlistRepository.searchById(id);
    }

    @Override
    public ListaReproduccion save(ListaReproduccion playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public void remove(ListaReproduccion playlist) {
        playlistRepository.remove(playlist);
    }
}
