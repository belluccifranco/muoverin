package com.vinilo.service;

import com.vinilo.model.Playlist;
import java.util.List;

public interface PlaylistService {
    
    public List<Playlist> searchAll();
    
    public Playlist searchById(long id);
    
    public Playlist save(Playlist playlist);

    public void remove(Playlist playlist);
}
