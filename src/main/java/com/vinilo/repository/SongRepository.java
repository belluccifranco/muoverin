package com.vinilo.repository;

import com.vinilo.model.Song;
import com.vinilo.model.Pagination;

public interface SongRepository extends BaseRepository<Song> {

    public Song searchByNameAndAlbum(String name, long id_album);

    public Pagination<Song> searchByCriteria(String criteria, int maxResultsPerPage, int pageIndex);
}
