package com.vinilo.service;

import com.vinilo.model.Artist;
import java.util.List;

public interface ArtistService {
    
    public List<Artist> searchAll();
    
    public Artist searchById(long id);
    
    public Artist searchByName(String name);
    
    public List<Artist> searchByNameLike(String name);
    
    public Artist save(Artist artist);
    
    public void remove(Artist artist);
}
