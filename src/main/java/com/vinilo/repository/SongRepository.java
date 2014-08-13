package com.vinilo.repository;

import com.vinilo.model.Song;
import com.vinilo.model.Pagination;
import java.util.List;

public interface SongRepository {

    public List<Song> searchAll();

    public Song searchById(long id);
    
    public Song searchByName(String name);

    public Song save(Song song);

    public void remove(Song song);

    public Pagination<Song> searchByCriteria(String criteria, int maxResultsPerPage, int pageIndex);
}
