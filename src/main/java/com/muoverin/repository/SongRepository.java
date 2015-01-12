package com.muoverin.repository;

import com.muoverin.model.Song;
import com.muoverin.model.Pagination;

public interface SongRepository extends BaseRepository<Song> {

    public Song searchByNameAndAlbum(String name, long id_album);

    public Pagination<Song> searchByCriteria(String criteria, int maxResultsPerPage, int pageIndex);
}
