package com.vinilo.repository;

import com.vinilo.model.Album;
import java.util.List;

public interface AlbumRepository {

    public List<Album> searchAll();

    public Album searchById(long id);

    public Album save(Album album);

    public void remove(Album album);
    
    public List<Album> searchByArtists(List<Long> artists_id);
    
    public Album searchByName(String name);
}
