package com.vinilo.repository;

import com.vinilo.model.Playlist;
import java.util.List;

public interface PlaylistRepository {

    public List<Playlist> searchAll();

    public Playlist searchById(long id);

    public Playlist save(Playlist playlist);

    public void remove(Playlist playlist);
}
