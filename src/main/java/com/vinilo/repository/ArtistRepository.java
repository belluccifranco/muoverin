package com.vinilo.repository;

import com.vinilo.model.Artist;
import java.util.List;

public interface ArtistRepository extends BaseRepository<Artist> {

    public Artist searchByName(String name);

    public List<Artist> searchByNameLike(String name);

}
