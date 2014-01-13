package com.vinilo.service;

import com.vinilo.model.Playlist;
import java.util.List;

public interface PlaylistService {
    
    public List<Playlist> searchAllPlaylists();
    
    public Playlist searchById(Long id);
    
    public Playlist save(Playlist playlist);

    public void remove(Playlist playlist);
}
