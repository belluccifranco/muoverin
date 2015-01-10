package com.vinilo.repository;

import com.vinilo.model.Album;
import java.util.List;

public interface AlbumRepository extends BaseRepository<Album> {

    public List<Album> searchByArtists(List<Long> artists_id);

    public Album searchByName(String name);
}
