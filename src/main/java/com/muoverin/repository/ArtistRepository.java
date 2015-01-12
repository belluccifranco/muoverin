package com.muoverin.repository;

import com.muoverin.model.Artist;
import java.util.List;

public interface ArtistRepository extends BaseRepository<Artist> {

    public Artist searchByName(String name);

    public List<Artist> searchByNameLike(String name);

}
