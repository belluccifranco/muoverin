package com.vinilo.service;

import com.vinilo.model.Song;
import com.vinilo.model.Pagination;
import java.util.List;

public interface SongService {

    public List<Song> searchAll();

    public Song searchById(long id);

    public Song save(Song song);

    public void remove(Song song);

    public Pagination<Song> searchByCriteria(String criteria, int pageIndex);
}
