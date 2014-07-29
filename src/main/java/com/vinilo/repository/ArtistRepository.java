package com.vinilo.repository;

import com.vinilo.model.Artist;
import java.util.List;

public interface ArtistRepository {

    public List<Artist> searchAll();

    public Artist searchById(long id);
    
    public Artist searchByName(String name);

    public Artist save(Artist artist);

    public void remove(Artist artist);
}
