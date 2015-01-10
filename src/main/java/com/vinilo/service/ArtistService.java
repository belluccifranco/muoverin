package com.vinilo.service;

import com.vinilo.model.Artist;
import java.util.List;

public interface ArtistService extends BaseService<Artist> {

    public Artist searchByName(String name);

    public List<Artist> searchByNameLike(String name);

}
