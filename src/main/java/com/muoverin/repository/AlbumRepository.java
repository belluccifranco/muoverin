package com.muoverin.repository;

import com.muoverin.model.Album;
import java.util.List;

public interface AlbumRepository extends BaseRepository<Album> {

    public List<Album> searchByArtists(List<Long> artists_id);

    public Album searchByName(String name);
}
