package com.vinilo.service;

import com.vinilo.model.Album;
import java.util.List;

public interface AlbumService extends BaseService<Album> {

    public List<Album> searchByArtists(List<Long> artists_id);

    public Album searchByName(String name);
}
