package com.muoverin.service;

import com.muoverin.model.Album;
import java.util.List;

public interface AlbumService extends BaseService<Album> {

    public List<Album> searchByArtists(List<Long> artists_id);

    public Album searchByName(String name);
}
