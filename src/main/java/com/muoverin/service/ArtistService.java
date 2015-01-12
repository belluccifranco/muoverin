package com.muoverin.service;

import com.muoverin.model.Artist;
import java.util.List;

public interface ArtistService extends BaseService<Artist> {

    public Artist searchByName(String name);

    public List<Artist> searchByNameLike(String name);

}
