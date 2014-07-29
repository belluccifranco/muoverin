package com.vinilo.service;

import com.vinilo.model.Album;
import java.util.List;

public interface AlbumService {

    public List<Album> searchAll();

    public Album searchById(long id);

    public Album save(Album album);

    public void remove(Album album);

    public List<Album> searchByArtist(long id_artist);

    public Album searchByName(String name);
}
